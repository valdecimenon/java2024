package com.softgraf.farmacia.view;

import java.util.Scanner;

public class Teclado {
	
	private static Scanner teclado;
	
	// inicializado estático
	// é o primeiro método a ser executado automaticamente quando a classe for carregado
	static {
		teclado = new Scanner(System.in);
	}
	
	//  construtor privado
	private Teclado() { }
	
	public static void msg(String msg) {
		System.out.println(msg);
	}
	
	public static String lerString(String msg) {
		msg(msg);
		return teclado.next();
	}
	
	public static String lerLinha(String msg) {
		// para corrigir problema do nextLine()
		teclado = new Scanner(System.in);
		msg(msg);
		return teclado.nextLine();
	}
	
	public static boolean lerSN(String msg) {
		String resp = null;
		do {
			resp = lerString(msg).toUpperCase();
		} while (!resp.equals("S") && !resp.equals("N"));
		return resp.equals("S");
	}
	
	public static int lerInt(String msg) {
		msg(msg);
		return Integer.parseInt(teclado.next());
	}
	
	public static long lerLong(String msg) {
		msg(msg);
		return Long.parseLong(teclado.next());
	}
	
	public static float lerFloat(String msg) {
		msg(msg);
		return Float.parseFloat(teclado.next());
	}
}
