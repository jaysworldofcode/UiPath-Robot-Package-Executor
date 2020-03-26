package executor;

import java.io.File;

public class DeletePath {
    public DeletePath(String Path){
        File dir = new File(Path);
         if (dir.isDirectory())
         {
               dir.delete();
         }
    }
}
