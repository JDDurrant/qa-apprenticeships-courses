package com.jackdurrant.io;

import java.io.*;
import java.nio.channels.FileChannel;

import javax.swing.*;

public class FileHandler
{
	private static void write(String fileName, boolean append) throws IOException
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

	public static void writeToFile(String fileName) throws IOException
	{
		write(fileName, false);
	}

	public static void addToFile(String fileName) throws IOException
	{
		write(fileName, true);
	}

	public static void readFirstTwoLines(String fileName) throws IOException
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

	public static String readFile(String file) throws IOException
	{
		final FileReader reader = new FileReader(file);
		final BufferedReader buffer = new BufferedReader(reader);
		String line;

		String contents = new String();

		try {
//			for(int i = 0; i < calcLinesInTheFile(file); i++) {
//				contents += buffer.readLine();
//			}

			line = buffer.readLine();

			while(!line.equals(null)) {
				contents += line;
				contents += "\n";
				line = buffer.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		} finally {
			buffer.close();
		}

		return contents;
	}

	public static String readLine(final BufferedReader buffer) throws IOException
	{
		try {
			return buffer.readLine();
		} catch(FileNotFoundException e) {
			// File not found
			throw e;
		} catch (EOFException e) {
			// End of file
			throw e;
		} catch (Exception e) {
			// Generic exception
			throw e;
		} finally {
			buffer.close();
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

// Edited by Jack Durrant