package telran.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;

class FileTests {
File file; 
int depth=0;

@BeforeEach
void setUp() {
	file = new File("dir1/dir2");
	file.delete();
}
	@Test
	void newDirectoryTest() {
		assertFalse(file.exists());
		file.mkdirs();
		assertTrue(file.exists());
	}
	@Test
	void printDirectoryContent() {
		printDirectory("C:\\1",-1);
	}
	
	/**
	 * 
	 * @param pathName name of path to initial directory
	 * @param level of sub-dir printing
	 * example, level = 1 printing only first level of the initial directory
	 *          level = 2 content+ sub-directories content
	 *          ....
	 *          level =-1 printing all levels
	 *         
	 */
	private void printDirectory(String pathName, int level) {
		
		/*
		 <dir> type=dir
		    <dir> type=dir
		      <file> type=file
		      <dir> type =dir
		   
*/
     	File dir = new File(pathName);
     	
     	if (level==-1) {depth=1000;}
     	else {
     	depth=level;}
     	printDir(dir,0);
    	
	}
	
	private void printDir(File dir,int level) {
		if (dir.isDirectory()){
			for (File file: dir.listFiles()) {
				if (file.isDirectory()) {
					System.out.println(freeSpaceCount(file.getParent().length())+ file.getName()+"=dir");
					level++;
				    if (level<=depth) {	
					printDir(file,level);
				    }
				}
				if (file.isFile()) {
					System.out.println(freeSpaceCount(file.getParent().length())+file.getName()+"=file");
				}
			}
		}
		else System.out.println("Wrong directory path");
	}
	
	
	private String freeSpaceCount(int n ) {
	String res="";
		for (int i=1; i<n;i++) {
			res=res+"  ";
		}
		 return res;
	}
	

		
		
		
	}

	
	 
