import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class ReadLorgFile_V2 {
	
	//private final static String basicLorgeFile = "E:/Git-repo/CoreJavaGit/CoreJava/ReadLorgeFile/Employee.csv";
	//private final static String searchFxIDsFile = "E:/Git-repo/CoreJavaGit/CoreJava/ReadLorgeFile/FexIds.txt";
	
	private final static String basicLorgeFile = "Employee.csv";
	private final static String searchFxIDsFile = "FexIds.txt";
		
	
	public static void main(String[] args) {
		System.out.println("Started Main");
		List<String> searchFxIdList = readSearchFile();
		System.out.println("searchFxIdList size: "+searchFxIdList.size());
		Map<String, String> resultedMap = findSelectedIdFronFile(searchFxIdList);
		System.out.println("resultedMap size: "+resultedMap.size());
		//createSelectedIdsFile(resultedMap);
		System.out.println("createSelectedIdsFile ");
	}

	private static void createSelectedIdsFile(Map<String, String> resultedMap) {
		System.out.println("createSelectedIdsFile started");
		FileOutputStream fos = null;
		
		Set<Entry<String, String>> li = resultedMap.entrySet();
		
		try {
			fos = new FileOutputStream("SearchedDataFile.txt");
			for (Entry<String, String> entry : li) {
				System.out.println("Employee Data: "+entry.getValue());
				//fos.write(entry.getValue()+"\n".getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fos.flush();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static Map<String, String> findSelectedIdFronFile(
			List<String> searchFxIdList) {
		System.out.println("FindSelectedIdFronFile() started ");
		 Map<String, String> resultMap = new HashMap<String, String>();
			try(BufferedReader in = new BufferedReader(new FileReader(basicLorgeFile))) {
			    try (PrintWriter writer = new PrintWriter(new File("SearchedDataFile.csv"))) {
			    	String line;
			    while ((line = in.readLine()) != null) {
			    	String arr[] = line.split("\\|");
			    	if(searchFxIdList != null && arr != null && arr[0] != null){
			    		if(searchFxIdList.contains(arr[0])){
			    			System.out.println("put row data in map: "+arr[0]);
			    			writer.write(line+"\n");
			    		}
			    	}
			    }
		    } catch (FileNotFoundException e) {
		    	System.out.println(e.getMessage());
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultMap;
	}

	private static List<String> readSearchFile() {
		System.out.println("ReadSearchFile Started");

		List<String> searchFxIdList = new ArrayList<String>();
		
		/*List<String> alist = Files.lines(Paths.get(pathname))
			    .filter(line -> line.contains("abc"))
			    .collect(Collectors.toList());*/
		try(BufferedReader in = new BufferedReader(new FileReader(searchFxIDsFile))) {
		    String line;
		    while ((line = in.readLine()) != null) {
	    		searchFxIdList.add(line);
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchFxIdList;
	}
}
