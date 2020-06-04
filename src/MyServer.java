
import com.vmm.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyServer extends JHTTPServer {

    MyServer(int portno) throws Exception {
        super(portno);
    }

    // All Logics of HttpServer like GetResource, login, signup
    // should be written in `serve` method
    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
        Response res = null;

        System.out.println(uri);

        //send file Logic
        if (uri.contains("GetResource")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri);
            res = sendCompleteFile(uri);
        } else if (uri.contains("deletevideo")) {
            System.out.println("hello..........");
            String video_id = parms.getProperty("videoid");
            System.out.println("id :" + video_id);
            try {

                ResultSet rs = DbLoader.executeQuery("select * from addvideo where video_id='" + video_id + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("/AdminLogin")) {
            try {
                /// *** Login Check Logic ****
                String u = parms.getProperty("email");
                String p = parms.getProperty("password");

                System.out.println("u : " + u);
                System.out.println("p : " + p);
                //check from db

                ResultSet resultSet = DbLoader.executeQuery("select * from admin where email='" + u + "' and password = '" + p + "'");
                if (resultSet.next()) {
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {

                    res = new Response(HTTP_OK, "text/plain", "failed");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (uri.contains("/AddCourse")) {
            /// *** Add Course logic *** ///
            String name = parms.getProperty("name");
            String discription = parms.getProperty("discription");
            String category = parms.getProperty("category");
            String prerequisite = parms.getProperty("prerequisite");
            String amount = parms.getProperty("amount");
            String filename1 = saveFileOnServerWithRandomName(files, parms, "square", "src/contentfolder");
            String filename2 = saveFileOnServerWithRandomName(files, parms, "wide", "src/contentfolder");
            String filename3 = saveFileOnServerWithRandomName(files, parms, "sampleVideo", "src/contentfolder");

            ResultSet rs = DbLoader.executeQuery("Select * from addcourse where name ='" + name + "'");
            String ans = "";
            try {
                if (rs.next()) {

                    ans = "alreadyexists";

                } else {

                    rs.moveToInsertRow();
                    rs.updateString("name", name);
                    rs.updateString("discription", discription);
                    rs.updateString("category", category);
                    rs.updateString("prerequisite", prerequisite);
                    rs.updateString("amount", amount);
                    rs.updateString("square", "src/contentfolder/" + filename1);
                    rs.updateString("wide", "src/contentfolder/" + filename2);
                    rs.updateString("sampleVideo", "src/contentfolder/" + filename3);
                    rs.insertRow();
                    ans = "rowadded";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/fetchdata")) {
            //***fetching logic***//
            ResultSet rs = DbLoader.executeQuery("select * from addcourse");
            String ans = "";
            try {

                while (rs.next()) {
                    String name = rs.getString("name");
                    String category = rs.getString("category");
                    String requisite = rs.getString("prerequisite");
                    int amount = rs.getInt("amount");
                    ans += (name + ";" + category + ";" + requisite + ";" + amount + "~");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);
        } else if (uri.contains("/deletecourse")) {

            String Coursename = parms.getProperty("coursename");
            try {

                ResultSet rs = DbLoader.executeQuery("select * from addcourse where name='" + Coursename + "'");
                if (rs.next()) {
                    rs.deleteRow();
                }
                res = new Response(HTTP_OK, "text/plain", "success");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("sendcourses")) {

            try {

                String cat = parms.getProperty("category");
                System.out.println(cat);
                ResultSet rs = DbLoader.executeQuery("select * from addcourse where category='" + cat + "'");

                String ans = "";
                while (rs.next()) {
                    String cname = rs.getString("name");
                    ans = ans + cname + ";";
                }

                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("addvideo")) {
            String course = parms.getProperty("course");
            String lacnum = parms.getProperty("lacnum");
            String title = parms.getProperty("title");
            String duration = parms.getProperty("duration");

            String filename1 = saveFileOnServerWithRandomName(files, parms, "video", "src/videocontent");
            String filename2 = saveFileOnServerWithRandomName(files, parms, "vtitle", "src/videocontent");

            ResultSet rs = DbLoader.executeQuery("Select * from addvideo ");
            String ans = "";
            try {

                rs.moveToInsertRow();
                rs.updateString("lacnum", lacnum);
                rs.updateString("title", title);
                rs.updateString("duration", duration);
                rs.updateString("course", course);
                rs.updateString("video", "src/videocontent/" + filename1);
                rs.updateString("vtitle", "src/videocontent/" + filename2);

                rs.insertRow();
                ans = "rowadded";

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("fetchvideo")) {
            ResultSet rs = DbLoader.executeQuery("select * from addvideo");
            String ans = "";
            try {

                while (rs.next()) {
                    int video_id = rs.getInt("video_id");
                    String lacnum = rs.getString("lacnum");
                    String title = rs.getString("title");
                    String duration = rs.getString("duration");
                    ans += (video_id + ";" + lacnum + ";" + title + ";" + duration + "~");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("deletevideo")) {
            System.out.println("hello..........");
            String video_id = parms.getProperty("videoid");
            System.out.println("id :" + video_id);
            try {

                ResultSet rs = DbLoader.executeQuery("select * from addvideo where video_id='" + video_id + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("/adduser")) {
            /// *** Add Course logic *** ///
            String email = parms.getProperty("email");
            String password = parms.getProperty("password");
            String phone = parms.getProperty("phone");
            String name = parms.getProperty("name");

            String filename1 = saveFileOnServerWithRandomName(files, parms, "photo", "src/userphoto");
            ResultSet rs = DbLoader.executeQuery("Select * from user where name ='" + email + "'");
            String ans = "";
            try {
                if (rs.next()) {

                    ans = "alreadyexists";

                } else {

                    rs.moveToInsertRow();
                    rs.updateString("email", email);
                    rs.updateString("password", password);
                    rs.updateString("phone", phone);
                    rs.updateString("name", name);

                    rs.updateString("photo", "src/userphoto/" + filename1);
                    rs.insertRow();
                    ans = "rowadded";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/userLogin")) {
            try {
                /// *** User Login Check Logic ****
                String u = parms.getProperty("email");
                String p = parms.getProperty("password");

                System.out.println("u : " + u);
                System.out.println("p : " + p);
                //check from db

                ResultSet resultSet = DbLoader.executeQuery("select * from user where email='" + u + "' and password = '" + p + "'");
                if (resultSet.next()) {
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {

                    res = new Response(HTTP_OK, "text/plain", "failed");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (uri.contains("fetchcourseundercategory")) {
            String cname = parms.getProperty("Cname");
            ResultSet rs = DbLoader.executeQuery("select * from addcourse where category='" + cname + "'");
            String ans = "";
            try {

                while (rs.next()) {

                    String photo = rs.getString("square");
                    String course = rs.getString("name");
                    int amount = rs.getInt("amount");
                    ans += (photo + ";" + course + ";" + amount + "~");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("fetchfullcourseview")) {
            String cname = parms.getProperty("cname");
            String email = parms.getProperty("email");
            ResultSet rs = DbLoader.executeQuery("select * from addcourse where name='" + cname + "'");
            String ans = "";
            try {

                if (rs.next()) {
                    String name = rs.getString("name");
                    String photo = rs.getString("square");
                    String requisite = rs.getString("prerequisite");
                    String category = rs.getString("category");
                    String photo_wide = rs.getString("wide");
                    String samplevideo = rs.getString("sampleVideo");
                    int amount = rs.getInt("amount");
                    ans += (name + ";" + photo + ";" + photo_wide + ";" + requisite + ";" + category + ";" + amount + ";" + samplevideo + ";");

                }

                ResultSet rs1 = DbLoader.executeQuery("select * from usersubscription where email='" + email + "' and coursename='" + cname + "'");
                if (rs1.next()) {
                    ans = ans + "yes;";
                } else {
                    ans = ans + "no;";

                }

                System.out.println(ans);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //db loder

            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("fetchallvideos")) {
            String cname = parms.getProperty("Cname");
            ResultSet rs = DbLoader.executeQuery("select * from addvideo where course='" + cname + "'");
            String ans = "";
            try {

                while (rs.next()) {
                    String lacnum = rs.getString("lacnum");
                    String title = rs.getString("title");
                    String duration = rs.getString("duration");
                    String vtitle = rs.getString("vtitle");
                    String video = rs.getString("video");

                    ans += (lacnum + ";" + title + ";" + duration + ";" + vtitle + ";" + video + "~");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("/subscribe")) {
            try {
                String email = parms.getProperty("email");
                String coursename = parms.getProperty("coursename");
                ResultSet rs = DbLoader.executeQuery("select * from usersubscription");
                rs.moveToInsertRow();
                rs.updateString("email", email);
                rs.updateString("coursename", coursename);
                rs.insertRow();

                res = new Response(HTTP_OK, "text/plain", "success");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("StreamMedia")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri);
            res = streamFile(uri, method, header);

        } else if (uri.contains("useremail")) {
            String email = parms.getProperty("email");
            System.out.println("email: " + email);
            ResultSet rs = DbLoader.executeQuery("select * from user where email='" + email + "'");
            String ans = "";
            try {

                if (rs.next()) {
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");

                    ans += (password + ";" + phone);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("/subscribe")) {
            try {
                String email = parms.getProperty("email");
                String coursename = parms.getProperty("coursename");
                ResultSet rs = DbLoader.executeQuery("select * from usersubscription");
                rs.moveToInsertRow();
                rs.updateString("email", email);
                rs.updateString("coursename", coursename);
                rs.insertRow();

                res = new Response(HTTP_OK, "text/plain", "success");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/changepassword")) {
            try {
                String email = parms.getProperty("email");
                String password = parms.getProperty("password");
                String newpassword = parms.getProperty("newpassword");
                ResultSet rs = DbLoader.executeQuery("select * from user where email='" + email + "' and password='" + password + "'");
                //rs.moveToInsertRow();
                //  rs.next();
                if (rs.next()) {
                    
                    rs.updateString("password", newpassword);
                    rs.updateRow();

                    res = new Response(HTTP_OK, "text/plain", "success");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } 
        else if (uri.contains("/fetchprofile")) {
            String email = parms.getProperty("email");
            
            System.out.println("email: " + email);
            ResultSet rs = DbLoader.executeQuery("select * from user where email='" + email + "'");
            String ans = "";
            try {

                if (rs.next()) {
                    
                    String photo = rs.getString("photo");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");

                    ans += (photo + ";" +name+ ";" + phone);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);
        }
        else if(uri.contains("/fetchsubscribedcourses")){
            
            try {
                String email = parms.getProperty("email");
                
                ResultSet rs = DbLoader.executeQuery("select * from addcourse where name in (select coursename from usersubscription where email ='"+email+"')");
                String ans ="";
                while(rs.next()){
                    
                    String name = rs.getString("name");
                    String photo = rs.getString("square");
                    ans = ans + name+";"+photo+"~";
                    
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        else {
            res = new Response(HTTP_OK, "text/plain", "Hello From Server");
        }

        return res;
    }

}
