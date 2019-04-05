# Cloud-Computing - API

## Client

```
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        String userName = request.getParameter("username").trim();
        String userPwd = request.getParameter("userpassword").trim();

        if(userName == null || userPwd == null) {
            response.sendRedirect("userlogin.html");
        }

        try {
            //Step 1: create URL
            URL url = new URL("http://localhost:9528/test/api/user/login");
            //Step 2: open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //Step 3: set parameters
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            out = null;

            out = new PrintWriter(connection.getOutputStream());
            out.print("username=" + userName + "&password=" + userPwd);
            out.flush();


            //Step 4: receive response from server
            int responseCode = connection.getResponseCode();
            System.out.println("code is: " + connection.getResponseCode());
            System.out.println("message is: " + connection.getResponseMessage());
            System.out.println("content type is: " + connection.getContentType());
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            
            // This is the return result in API Server
            System.out.println("result is:" + result);
        }catch (Exception e) {
            System.out.println("Catch Exception: " + e);
        }
        // close buffer
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
```

## Debug

In order to run the API server and Client under one tomcat server on IDEA,  we need to add war file of API to tomcat configurations. 

![](/img/Screenshot 2019-04-04 at 23.53.06.png)

![](/img/Screenshot 2019-04-04 at 23.53.26.png)



## Reference

1. [Creating and Running Your First RESTful Web Service on GlassFish Application Server](https://www.jetbrains.com/help/idea/creating-and-running-your-first-restful-web-service.html)

