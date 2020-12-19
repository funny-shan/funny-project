package com.funny.springcloud.entities;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * @Author linshan
 * @Date 2020/12/15
 * @desc 压缩文件，生成压缩文件工具类
 */
public class GZipUtils {
    public static void main(String[] args){
        List<String> list1 = new ArrayList<>();
        list1.add("a|a|a|a|a|a");
        list1.add("b|b|b|b|b|b");
        list1.add("c|c|c|c|c|c");
        list1.add("d|d|d|d|d|d");
        File file = new File("G11V_LONGZHIFU_ACTIVITY_20201215_0001.dat");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            for (String s : list1) {
                byte[] bytes = s.getBytes();
                int len = bytes.length;
                fos.write(bytes, 0, len);
                fos.write(System.getProperty("line.separator").getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<String> list2 = new ArrayList<>();
        list2.add("1|1|1|1|1|1|1|1");
        list2.add("2|2|2|2|2|2|2|2");
        list2.add("3|3|3|3|3|3|3|3");
        list2.add("4|4|4|4|4|4|4|4");
        File file2 = new File("G11V_LONGZHIFU_ACTIVITY_20201215_0002.dat");
        FileOutputStream fos2 = null;
        try {
            fos2 = new FileOutputStream(file2);
            for (String s : list2) {
                byte[] bytes = s.getBytes();
                int len = bytes.length;
                fos2.write(bytes, 0, len);
                fos2.write(System.getProperty("line.separator").getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<File> fileList = new ArrayList<>();
        fileList.add(new File("G11V_LONGZHIFU_ACTIVITY_20201215_0001.dat"));
        fileList.add(new File("G11V_LONGZHIFU_ACTIVITY_20201215_0002.dat"));
//        String folderPath = "/home/ap/nas_a/file/output/longzhifu_activity/data/YYYYMMDD";
//        String targzipFilePath = "/home/ap/nas_a/file/output/longzhifu_activity/data/YYYYMMDD";
//        String targzipFileName = "G11V_LONGZHIFU_ACTIVITY_20201214_0001.tar.gz";
        GZipUtils.CompressedFiles_Gzip(fileList,"f:\\funnyProject\\G11V_LONGZHIFU_ACTIVITY_20201215_0001.tar.gz");
    }

    /**
     * 压缩文件成Gzip格式(.tar.gz)，Linux上可使用
     * @param fileList,要压缩的文件列表
     * @param targzipFilePath,压缩后文件的路径和文件名
     * */
    public static void CompressedFiles_Gzip(List<File> fileList, String targzipFilePath)
    {
        int length = fileList.size();
        byte[] buf = new byte[1024]; //设定读入缓冲区尺寸
        try
        {
            //建立压缩文件输出流
            FileOutputStream fout=new FileOutputStream(targzipFilePath);
            //建立tar压缩输出流
            TarArchiveOutputStream tout=new TarArchiveOutputStream(fout);
            for(int i=0;i<length;i++)
            {
                File file = fileList.get(i);
                String filename = file.getName();
                //打开需压缩文件作为文件输入流
                FileInputStream fin=new FileInputStream(filename);   //filename是文件全路径
                TarArchiveEntry tarEn=new TarArchiveEntry(file);
                tarEn.setName(file.getName());  //此处需重置名称，默认是带全路径的，否则打包后会带全路径
                tout.putArchiveEntry(tarEn);
                int num;
                while ((num=fin.read(buf, 0, 1024)) != -1)
                {
                    tout.write(buf,0,num);
                }
                tout.closeArchiveEntry();
                fin.close();
            }
            tout.close();
            fout.close();
        }catch(FileNotFoundException e)
        {
            throw new RuntimeException("文件不存在!");
        }catch(IOException e)
        {
            throw new RuntimeException("流操作异常！");
        }
    }


}
