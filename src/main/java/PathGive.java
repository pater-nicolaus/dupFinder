public class PathGive {
    private void scanDirectory(File rootDirectory) {
        System.out.println(rootDirectory);

        File[] filesInDirectory = rootDirectory.listFiles();
        //System.out.prntln(filesInDirectory.toString());

        try {
            for (File file : filesInDirectory) {
                //System.out.println(file);

                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    list.add(file);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}