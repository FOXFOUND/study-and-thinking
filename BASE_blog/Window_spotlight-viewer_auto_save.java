package findwindow;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class AutoFindPic {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = System.getProperties();
		String currentUsername=prop.getProperty("user.name");
		System.out.println("\n当前用户名:" +currentUsername);
		String [] dirpath=new String[3];
		dirpath[0]="C:\\Users\\";
		dirpath[1]=currentUsername;
		dirpath[2]="\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets";
		File picFile=new File(prop.getProperty("user.home")+dirpath[2]);
		System.out.println(picFile.getPath());
		File[] files=picFile.listFiles();
		for(File f :files)
		{
			System.out.println(f.getName());
		}
		String desDirPath="D:\\windowspictures";
		File desDir=new File(desDirPath);
		if(desDir.exists())
		{
			File [] dirfiles=desDir.listFiles();
			for(File dirf :dirfiles)
			{
				System.out.println(dirf.getName()+"     "+"has been delete ");
				dirf.delete();
				
			}
			desDir.delete();
			System.out.println("has same");
		}
		desDir.mkdir();
		System.out.println("ok");
		
		for(int i=0;i<files.length;i++)
		{
			if(files[i].length()>1024*100)
			{
				SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd");//设置日期格式
				System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
				String today=df.format(new Date());
			Files.copy(files[i].toPath(), new File(desDirPath+"\\"+today+"_"+i+".jpg").toPath());
			}
		}
		System.out.println("successful");
	}

}
