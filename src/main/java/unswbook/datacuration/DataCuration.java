package unswbook.datacuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import unsw.curation.api.tokenization.ExtractionKeywordImpl;

public class DataCuration {

	String keywords = null;
	List<String> bullywords = null;
	ArrayList<String> result = new ArrayList<String>();

	public ArrayList<String> Keywords(String text) throws Exception {
		String path1 = "/Users/mrtuesday/Documents/eclipse_workspace/ass2/src/main/webapp/WEB-INF/lib/stopwordlist.txt";
		String path2 = "/Users/mrtuesday/Documents/eclipse_workspace/ass2/src/main/webapp/WEB-INF/lib/bully.txt";

		try {
			File file = new File(path2);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line.toLowerCase());
				stringBuffer.append(",");
			}
			fileReader.close();
			bullywords = Arrays.asList(stringBuffer.toString().split(","));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ExtractionKeywordImpl ek = new ExtractionKeywordImpl();
		keywords = ek.ExtractSentenceKeyword(text, new File(path1));
		List<String> kw = Arrays.asList(keywords.split(","));

		for (String s : kw) {
			if (bullywords.contains(s) && !result.contains(s)) {
				result.add(s);
			}
		}

		return result;
	}
}
