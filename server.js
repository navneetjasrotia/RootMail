var express=require('express');
var app=express();
var mysql=require('mysql');
app.set('view engine','ejs');
var bodyParser=require('body-parser');
app.use(bodyParser.json());
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));
var fs=require('fs');
var fileUpload=require('express-fileupload');
app.use(fileUpload());
var user="";
var file_present="";
const db  = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'Chamba@1',
  database: 'database1'
});
var mail="";
var sub="";
var des="";
db.connect(function(err){
  if (err) throw err;
  console.log("Connected To Mysql");
});

app.post('/checkfile',function(req,res){
console.log(req.body.username);
var s=req.body.username.substr(1,req.body.username.length-2);
var sql="(select file_send from send_email where sent_description = '"+s+"')";
db.query(sql,function(err,result){
  if(err)
  console.log(err);
  else
  {
    if(result[0].file_send=='No')
    {
      res.end(JSON.stringify({"File": "Not Present"}));
    }
    else{
      file_present=result[0].file_send;
      console.log(file_present);
      res.end(JSON.stringify({file_present: file_present}));
    }
  }
});


});



app.post('/mail',function(req,res)
{
  console.log(req.body);
  var user=parseInt(req.body.own_code);
  var sql="(select * from send_email where send_emp_code = '"+user+"')";
  mail="";
  sub="";
  des="";
  db.query(sql, function (err, result) {
    if (err) throw err;
    for(var i=0;i<result.length;i++)
    {
      if(i==(result.length)-1)
      {
        mail=mail+(JSON.stringify(result[i].mail_id));
        sub=sub+(JSON.stringify(result[i].sent_title));
        des=des+(JSON.stringify(result[i].sent_description));
      }
      else
      {
      mail=mail+(JSON.stringify(result[i].mail_id)+':');
      sub=sub+(JSON.stringify(result[i].sent_title)+':');
      des=des+(JSON.stringify(result[i].sent_description)+':');
      }
    }
    console.log(result)
    res.end(mail+"-"+sub+"-"+des);
});
});
app.post('/send',function(req,res)
{
var Fi="";
  console.log(req.files);
  if (!req.files) {
    console.log("No file");
    Fi="No";
  }
  else {
    console.log("File exists");
    let file=req.files.fileUpload;
    file.mv("public/"+file.name,()=>{});
    Fi=req.files.fileUpload.name;
  }
  var send_id=parseInt(req.body.e_code);
  var u=parseInt(req.body.own_code);
  console.log(Fi+"---"+u);
console.log(req.body);
 res.setHeader('Content-Type', 'application/json');
var sql="insert into send_email values('"+u+"','"+req.body.subject+"','"+req.body.desc+"','"+req.body.radio+"','"+send_id+"','"+Fi+"')";
  db.query(sql, function (err, result) {
    if (err)
  console.log(err);
    console.log("1 record inserted");
    res.end(JSON.stringify({ Inserted: 'ok' }));
});
});
app.post('/login',function(req,res)
{
res.setHeader('Content-Type', 'application/json');
   user=parseInt(req.body.username);
  var password=req.body.password;
 db.query('SELECT * FROM signup WHERE emp_code = ?',[user], function (error, results, fields) {
       if (error) {
           res.json({
             status:false,
             message:'there are some error with query'
             })
       }
       else{
         if(results.length >0){
             if(password==results[0].password){
                 res.json({
                     status:true,
                     message:'successfully authenticated'
                 })
             }
             else{
                 res.json({
                   status:false,
                   message:"Email and password does not match"
                  });
             }
         }
         else{
           res.json({
               status:false,
             message:"Email does not exits"
           });
         }
       }
     });
});
app.post('/signup',function(req,res)
{
  res.setHeader('Content-Type', 'application/json');
  var ec=parseInt(req.body.empcode);
  var sql = "insert into signup values('"+ec+"','"+req.body.name+"','"+req.body.email+"','"+req.body.state+"','"+req.body.phone+"','"+req.body.password+"','"+req.body.post+"')";
  db.query(sql, function (err, result) {
    console.log("Error occurred"+ err);
    console.log("1 record inserted");
res.end(JSON.stringify({ a: '1' }));
});
console.log(req.body);
});
app.listen(8888);
console.log('Now listening to port 8888');
