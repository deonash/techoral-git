package com.techoral.java24;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public class ForeignFunctions {

	public static void main(String[] args)
	{
		Linker linker = Linker.nativeLinker();
		SymbolLookup lookup = linker.defaultLookup();
		MethodHandle strlen = linker.downcallHandle(
				lookup.find("strlen").orElseThrow(),
				FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS)
				);
		try(Arena arena = Arena.ofConfined()){
			MemorySegment str = arena.allocateFrom("helloworkd");
			int length = (int) strlen.invokeExact(str);
			System.out.println(length);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
