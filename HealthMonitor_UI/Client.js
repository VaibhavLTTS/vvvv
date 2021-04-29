
  
const express= require("express");
const app=express();
app.use(express.static("image"));

app.get("/", (req, res) => {
    res.sendFile(__dirname + "/home.html");
  })
      
       
app.listen(1239, () => {
    console.log("run");
  })
  
  