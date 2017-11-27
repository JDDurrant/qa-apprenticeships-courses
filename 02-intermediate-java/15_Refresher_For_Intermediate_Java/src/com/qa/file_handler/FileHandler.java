package com.qa.file_handler;

import java.io.*;
import java.nio.channels.FileChannel;

import javax.swing.*;

public class FileHandler
{
	private static void WriteToFile(String fileName, boolean append) throws IOException
	{
		final FileWriter outputFile = new FileWriter(fileName, append);
		final BufferedWriter outputBuffer = new BufferedWriter(outputFile);
		final PrintWriter printstream = new PrintWriter(outputBuffer);

		String input = JOptionPane.showInputDialog("Enter a line, -1 to stop: ");

		while (!input.equalsIgnoreCase("-1"))
		{
			printstream.println(input + "\n");
			input = JOptionPane.showInputDialog("Enter a line, -1 to stop: ");
		}
		printstream.close();
	}

	public static void ReadFile(String fileName) throws IOException
	{
		final FileReader inputFile = new FileReader(fileName);
		final BufferedReader inputBuffer = new BufferedReader(inputFile);

		try{
			String line1 = inputBuffer.readLine();
			String line2 = inputBuffer.readLine();

			System.out.println("The following was stored in the file:" + line1 + "\n" + line2);

			inputBuffer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception " + e);
		} catch (EOFException e) {
			System.out.println("End of the file exception  " + e);
		}
		catch (Exception e) {
			System.out.println("Generic message for excetion " + e);
		}
		finally{
			inputBuffer.close();
			System.out.println("Resourses are closed ...");
		}
	}

	public static int calcLinesInTheFile(String fileName){
		BufferedReader br = null;
		int counter = 0;
		try {
			String sCurrentLine;

			final FileReader inputFile = new FileReader(fileName);
			br = new BufferedReader(inputFile);

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				counter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return counter;
	}

	public boolean copyFiles(String inputFile, String outputFile) {
		FileChannel sourceChannel = null;
		FileChannel destChannel = null;
		try {
			sourceChannel = new FileInputStream(inputFile).getChannel();
			destChannel = new FileOutputStream(outputFile).getChannel();
			destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} catch (Exception e) {
			System.out.println("something wrong " + e);
			return false;
		}
		System.out.println("Job is done.");
		return true;
	}

}
