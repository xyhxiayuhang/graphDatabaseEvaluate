package generateAnnotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class nQuadsToTriples {

	public static void main(String[] args) {
		File annotatedQuad = new File("AGmetaData.quad");
		File annoTriple = new File("AGTriples.nt");

		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(annotatedQuad));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				list.add(tempString);
			}
			FileWriter annotatedTripleWriter = new FileWriter(annoTriple.getName(), true);
			BufferedWriter annoTripleBuffer = new BufferedWriter(annotatedTripleWriter);
			int length = list.size(), location, loc2;
			String temp1, temp2, temp3, graph, s, p, o;
			for (int i = 0; i < length; i++) {
				temp1 = list.get(i);
				location = temp1.lastIndexOf("<");// ���һ��<���ֵ�λ��
				temp2 = temp1.substring(0, location - 1);// ȥ��graph�Ĳ���
				loc2 = temp1.lastIndexOf(">");
				graph = temp1.substring(location, loc2 + 1);
				s = temp2.substring(0, temp2.indexOf(">") + 1);
				temp1 = temp2.substring(temp2.indexOf(">") + 1, temp2.length());// temp2ȥ��s�Ĳ���
				p = temp1.substring(0, temp1.indexOf(">") + 1);// �õ�p
				o = temp1.substring(temp1.indexOf(">") + 2, temp1.length());// �õ�o

				// д���ļ��� g has s; g has p; g has o
				temp1 = graph + " <http://yago-knowledge.org/resource/hasS> " + s + ".\n"; // g
																							// has
																							// s
				temp2 = graph + " <http://yago-knowledge.org/resource/hasP> " + p + ".\n"; // g
																							// has
																							// p
				temp3 = graph + " <http://yago-knowledge.org/resource/hasO> " + o + ".\n"; // g
																							// has
																							// o
				annoTripleBuffer.write(temp1 + temp2 + temp3);
			}
			reader.close();
			annoTripleBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
