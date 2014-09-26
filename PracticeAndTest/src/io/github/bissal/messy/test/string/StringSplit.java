package io.github.bissal.messy.test.string;

public class StringSplit {
	public StringSplit() {
		
//		String rowData = "abc,\"abc\",\"banana\",\"apple\",\"ffff,";
//		String rowData = "abc,\"abc\",\"ban,ana\",\"app\nle\",\"ffff,";
//		
//		String[] currentColumnDatas = rowData.split(",");
//		System.out.println("rowData.split: " + currentColumnDatas.length);
//		
//		StringBuffer rePasteOnData = new StringBuffer();
//		
//		for(int i = 0; i < currentColumnDatas.length - 1; i++) {
//			
//			if(currentColumnDatas[i].startsWith("\"")) {
//											
//				if (currentColumnDatas[i].endsWith("\"")) {
//					rePasteOnData.append(currentColumnDatas[i]);
//					rePasteOnData.append(',');
//					
//				} else {
//					int j = i;
//					while (!currentColumnDatas[j].endsWith("\"")) {
//						rePasteOnData.append(currentColumnDatas[j]);
//						rePasteOnData.append(',');
//						j++;
//					}
//					rePasteOnData.append(currentColumnDatas[j]);
//					rePasteOnData.append(',');
//					i = j;
//				}
//			}
//		}
//		
//		System.out.println(rePasteOnData.toString());
//		
//		String str = "\"a,pp\nle\"".replace("\n", "\\n");
//		str = str.replace(",", "::");
//		System.out.println(str);
		
//		String dataString = "abc,\"abc\",\"ban,ana\",\"app\nle\",\"ffff,";
//		String[] rawData = dataString.split(",");
//		
//		StringBuffer parseData = new StringBuffer();
		
//		for(int i=0; i<rawData.length; i++) {
//			if(rawData[i].startsWith("\"")) {
//				do {
//					rawData[i] = rawData[i].replace("\n","???");
//					rawData[i] = rawData[i].replace(",", "!!!");
//					parseData.append(rawData[i]);
//					i++;
//				} while(rawData[i].endsWith("\""));
//			}
//			parseData.append(rawData[i]);
//		}
//		System.out.println(parseData.toString());
		
//		for(int i=1; i<rowResult.length; i++) {
//			int tempcount = rowResult[i-1].split(tempSeparator).length;
//			columnCount = rowResult[i].split(tempSeparator).length;
//			if(tempcount > columnCount) {
//				columnCount = tempcount;
//			}
//			
//		}
//		
//		for(int i = 0; i < rowResult.length - 1; i++) {
//			
//			int tempcount = rowResult[i].split(tempSeparator).length;
//			
//			if(tempcount > columnCount) {
//				columnCount = tempcount;
//			}			
//		}
		
		String[][] str = {{"a", null, "c"},{"d", "e", "f"},{"g", "h", "i"}};
		
		String[][] des = new String[3][3];
		
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
//				System.out.println(str[i][j]);
				des[i][j] = str[i][j];
				System.out.println("["+i+"]"+"["+j+"]: " + des[i][j]);
			}
		}	
		
		
	}

}
