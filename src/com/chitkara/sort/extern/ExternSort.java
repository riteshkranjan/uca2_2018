package com.chitkara.sort.extern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ExternSort {

	public static void main(String[] args) throws IOException {

		if (args.length < 2) {
			System.out.println("please provide input and output file names");
			return;
		}
		String inputfile = args[0];
		String outputfile = args[1];
		List<File> l = sortInBatch(new File(inputfile));
		mergeSortedFiles(l, new File(outputfile));
	}
	
	public static List<File> sortInBatch(File file) throws IOException {
		List<File> files = new ArrayList<File>();
		BufferedReader fbr = new BufferedReader(new FileReader(file));
		long blocksize = Runtime.getRuntime().freeMemory();
		try {
			List<String> tmplist = new ArrayList<String>();
			String line = "";
			try {
				while (line != null) {
					long currentblocksize = 0;
					while ((currentblocksize < blocksize) && ((line = fbr.readLine()) != null)) {
						tmplist.add(line);
						currentblocksize += line.length();
					}
					files.add(sortAndSave(tmplist));
					tmplist.clear();
				}
			} catch (EOFException oef) {
				if (tmplist.size() > 0) {
					files.add(sortAndSave(tmplist));
					tmplist.clear();
				}
			}
		} finally {
			fbr.close();
		}
		return files;
	}
	
	public static File sortAndSave(List<String> tmplist) throws IOException {
		Collections.sort(tmplist);
		File newtmpfile = File.createTempFile("sortInBatch", "flatfile");
		newtmpfile.deleteOnExit();
		BufferedWriter fbw = new BufferedWriter(new FileWriter(newtmpfile));
		try {
			for (String r : tmplist) {
				fbw.write(r);
				fbw.newLine();
			}
		} finally {
			fbw.close();
		}
		return newtmpfile;
	}


	private static void mergeSortedFiles(List<File> files, File outputfile) throws IOException {
		PriorityQueue<CustomBufferReader> pq = new PriorityQueue<CustomBufferReader>();
		for (File f : files) {
			CustomBufferReader bfb = new CustomBufferReader(f);
			pq.add(bfb);
		}
		BufferedWriter fbw = new BufferedWriter(new FileWriter(outputfile));
		try {
			while (pq.size() > 0) {
				CustomBufferReader bfb = pq.poll();
				String r = bfb.pop();
				fbw.write(r);
				fbw.newLine();
				if (bfb.empty()) {
					bfb.fbr.close();
					bfb.originalfile.delete();
				} else {
					pq.add(bfb);
				}
			}
		} finally {
			fbw.close();
			for (CustomBufferReader bfb : pq)
				bfb.close();
		}
	}

}
