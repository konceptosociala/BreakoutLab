public class Debug {
	/**
	 * Prints a debug message to the console.
	 * The message is prefixed with "[DEBUG]" for easy identification.
	 *
	 * @param msg The string message to be printed.
	 */
	public static void print(String msg) {
		java.lang.System.out.println("[DEBUG] " + msg);
	}
	/**
	 * Prints a debug message to the console.
	 * The message is prefixed with "[DEBUG]" for easy identification.
	 *
	 * @param msg The integer message to be printed.
	 */
	public static void print(int msg) {
		java.lang.System.out.println("[DEBUG] " + msg);
	}
}
