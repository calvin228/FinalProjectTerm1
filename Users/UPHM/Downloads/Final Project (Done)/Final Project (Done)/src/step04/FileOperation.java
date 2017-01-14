package step04;

public class FileOperation {
    public static void main(String[] args) {
        FileUtilV4 futil = new FileUtilV4();
        // open existing file to read
        String s1 = futil.openReadFile("abc.txt");
        System.out.println(s1);
        
        while(futil.getReadScanner().hasNext()) {
            // read line per line, split line by comma delimiter
            String[] readLine = futil.getReadScanner().next().split(",");
            
            // printout per line
            String name = readLine[0];
            int age = Integer.parseInt(readLine[1]);
            double salary = Double.parseDouble(readLine[2]);            
            System.out.printf("%s\t%d\t%f%n",name,age,salary);
        }        
        // close opening read file
        String s3 = futil.closeReadFile();
        System.out.println(s3);
    }
}


