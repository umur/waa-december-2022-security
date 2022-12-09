/**
 * app.js
 */
 "use strict";
window.onload=function(){
 

    getStudents();
}

function getStudents() {
        
    const response =  fetch("http://localhost:8080/products")
    .then(response=>response.json()).then(usersData=>{
        let row = "";
        usersData.forEach(element => {
            
             row+=`<tr>
            <td>${element.id} </td>
            <td>${element.firstName}</td>
            <td>${element.lastName}</td>
            <td>${element.email}</td>
            <td>${element.major}</td>
            <td>
            <button class="btn btn-success" onclick="updateStudent(${element.id})">Update</button>
            <button class="btn btn-danger" onclick="deleteStudent(${element.id})">Delete</button></td>
          </tr>`;
            
        });
        document.getElementById("student-data").innerHTML=row;

    })  
}

function deleteStudent(id){
    fetch(`http://localhost:8080/students/${id}`,{
        method:"DELETE"
    })
    .then(usersData=>{
       getStudents();
    });

}


function saveStudent(){

    let firstName=document.getElementById("firstName").value;
    let lastName=document.getElementById("lastName").value;
    let id=document.getElementById("id").value;
    let email=document.getElementById("email").value;
    let major=document.getElementById("major").value;

    let method="POST";
    let url="http://localhost:8080/students";
    if(document.getElementById("update").value==="1")
    {
        method="PUT";
        url=`http://localhost:8080/students/${id}`

    }


    fetch(url,{
        
        method:method,
        body:JSON.stringify({
            'id':id,
            'firstName':firstName,
            'lastName':lastName,
            'email':email,
            'major':major


        }),
        headers: {
            'Content-Type': 'application/json'
          },
    

    }).then((response)=>{
        document.getElementById("student-form").reset();
        getStudents();
    });

}

function updateStudent(id){
fetch(`http://localhost:8080/students/${id}`,{
    method:"GET"
})
.then(response=>response.json()).then(studentData=>{
document.getElementById("id").value=studentData.id;
document.getElementById("id").readOnly=true;
   document.getElementById("firstName").value=studentData.firstName;
   document.getElementById("lastName").value=studentData.lastName;
   document.getElementById("major").value=studentData.major;
   document.getElementById("email").value=studentData.email;

   document.getElementById("button").innerHTML=`<button class="btn btn-primary form-control " onclick="saveStudent()">Update Student</button>`;
   document.getElementById("update").value=1
});
}
