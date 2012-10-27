/**
 * 
 */
package utils;

import java.util.List;

import play.data.Form.Field;
import play.libs.F.Tuple;

/**
 * @author bran
 *
 */
public class Forms {
	public static String fieldSpecs(Field fld) {
		List<Tuple<String, List<Object>>> css = fld.constraints();
		boolean hasConstraints = false;
		String re = "";
		for (Tuple<String, List<Object>> cs : css) {
			if (!hasConstraints) {
				re += "Constraints: ";
				hasConstraints = true;
			}
			re += "'" + cs._1 + "'";
			re = appendDetail(re, cs._2);
		}
		
		if (hasConstraints) {
			re += ". ";
		}

		Tuple<String, List<Object>> format = fld.format();
		if (format != null) {
			re += "Format: " + "'" + format._1 + "'";
			re = appendDetail(re, format._2);
		}
		
		return re;
	}

	private static String appendDetail(String re, List<Object> cs) {
		boolean hasDetail = false;
		for (Object o: cs) {
			if (!hasDetail) {
				hasDetail = true;
				re += "[";
			}
			re +=o + ", ";
		}
		if (hasDetail) {
			re = re.substring(0, re.lastIndexOf(", "));
			re += "]";
		}
		return re;
	}
	
	public static boolean hasError(Field fld) {
		return fld.errors() != null && fld.errors().size() > 0;
	}
}
