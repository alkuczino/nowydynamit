
import java.io.*;
import java.net.InterfaceAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Rafał on 21.05.2017.
 */
public class Client {

    public static String diff;
    public static void getHighScores(Configuration config,String ip, String port) {

        try {
            connect(config,"GETHIGHSCORES", ip, port);

        } catch (NumberFormatException e) {

        }}

    public static void getLevel (Configuration config,String ip, String port){


        try {
            connect(config,"GETLEVEL", ip, port);
        } catch (NumberFormatException e) {

        }

    }
    public static void getDifficulty (Configuration config, String ip, String port,String difficulty){
        try {diff=difficulty;
            connect(config, "GETDIFFICULTY", ip, port);
        }
            catch(NumberFormatException e){

            }
        }

        public static void getMapSize(Configuration config, String ip, String port){
        try {
            connect(config,"GETMAPSIZE",ip,port);
        }catch(NumberFormatException e){

            }

        }

    public static void getLevelNumber(String ip, String port, int level) throws IOException {
        try{
            Socket socket;
            socket = new Socket(ip, Integer.parseInt(port));
            socket.setSoTimeout(5000);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println("GETLEVELNUMBER");
            pw.println(level);
        } catch (UnknownHostException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void connect(Configuration config,String command,String ip, String port) {
        try {
            Socket socket = new Socket(ip, Integer.parseInt(port));
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));


            switch(command){
                case "GETHIGHSCORES":
                {
                pw.println("GETHIGHSCORES");
                String[] tmp = new String[10];
                String tmpText = br.readLine();
                int i=0;
                do{
                    tmp[i]=tmpText;
                    tmpText=br.readLine();
                    i++;
                } while(tmpText!=null);
                config.setHighScores(tmp);
                br.close();
                break;



                }
                case "GETMAPSIZE":{
                    pw.println("GETMAPSIZE");
                    int mapsize=Integer.parseInt(br.readLine());
                   config.setMapSize(mapsize);
                br.close();
                break;

                }
                case "GETDIFFICULTY":{
                    pw.println("GETDIFFICULTY");
                    pw.println(diff);

                    config.setRoundTime(Integer.parseInt(br.readLine()));
                    config.setLifeNumber(Integer.parseInt(br.readLine()));
                br.close();
                break;

                }
                case "GETLEVEL":{
                    pw.println("GETLEVEL");
                    int tmpSize=config.getMapSize();
                    int[][]map=new int[tmpSize][tmpSize];
                    int[][] tmpInt = new int[tmpSize][tmpSize];
                    for(int j = 0; j< tmpSize; j++)
                    {
                        for(int k = 0; k< tmpSize; k++)
                            map[j][k]=Integer.parseInt(br.readLine());
                    }
                    config.setMap1(map);
                    br.close();
                    break;
                }
                case "GETLEVELNUMBER":{
                    int levelnumber;
                    levelnumber = Integer.parseInt(br.readLine());
                    br.close();
                    break;

                }



            }

            socket.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e);
        }
    }


}
