package Utils;

import java.util.Hashtable;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.crashapps.artexperience.BuildConfig;


public class TypeFaceProvider {

	public static final String TYPEFACE_FOLDER = "fonts";
	public static final String TYPEFACE_EXTENSION = ".ttf";

	private static Hashtable<String, Typeface> sTypeFaces = new Hashtable<String, Typeface>(
			4);

	private static Typeface getTypeFace(Context context, String fileName) {
		Typeface tempTypeface = sTypeFaces.get(fileName);

		if (tempTypeface == null) {
			String fontPath = new StringBuilder(TYPEFACE_FOLDER).append('/')
					.append(fileName).append(TYPEFACE_EXTENSION).toString();
			tempTypeface = Typeface.createFromAsset(context.getAssets(),
					fontPath);
			sTypeFaces.put(fileName, tempTypeface);
		}

		return tempTypeface;
	}

	public static void overrideFonts(final Context context, final View v) {
		String fontName="RobotoSlab-Regular";
		overrideFonts(context, v, fontName);
	}
	
	private static void overrideFonts(final Context context, final View v,
			String fontName) {
		try {
			if (v instanceof ViewGroup) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0; i < vg.getChildCount(); i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child, fontName);
				}
			} else {

				if (v instanceof TextView) {
					TextView v1 = (TextView) v;

					v1.setTypeface(TypeFaceProvider.getTypeFace(context,
							fontName));
				} else if (v instanceof EditText) {
					EditText v1 = (EditText) v;

					((EditText) v).setTypeface(TypeFaceProvider.getTypeFace(
							context, fontName));
				} else if (v instanceof Button) {
					Button v1 = (Button) v;

					((Button) v).setTypeface(TypeFaceProvider.getTypeFace(
							context, fontName));
				}
			}
		} catch (Exception e) {
			if (BuildConfig.DEBUG)
			e.printStackTrace();
		}
	}

}