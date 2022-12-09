'use strict';
window.onload=function(){
    getCourses();
}
function getCourses() {
        
    const response =  fetch("http://localhost:8080/courses")
    .then(response=>response.json()).then(courseData=>{
    
        let row = "";
        courseData.forEach(element => {
            
             row+=`<tr>
            <td>${element.id} </td>
            <td>${element.name}</td>
            <td>${element.code}</td>
           
            <td>
            <button class="btn btn-success" onclick="updateCourse(${element.id})">Update</button>
            <button class="btn btn-danger" onclick="deleteCourse(${element.id})">Delete</button></td>
          </tr>`;
            
        });
        document.getElementById("course-data").innerHTML=row;

    })  
}

function deleteCourse(id){
    fetch(`http://localhost:8080/courses/${id}`,{
        method:"DELETE"
    })
    .then(usersData=>{
       getCourses();
    });
}



function saveCourse(){

        let name=document.getElementById("name").value;
        let code=document.getElementById("code").value;
        let id=document.getElementById("id").value;
        let method="POST";
        let url="http://localhost:8080/courses";
        if(document.getElementById("update").value==="1")
        {
            method="PUT";
            url=`http://localhost:8080/courses/${id}`

        }


        fetch(url,{
            
            method:method,
            body:JSON.stringify({
                'id':id,
                'name':name,
                'code':code

            }),
            headers: {
                'Content-Type': 'application/json'
              },
        

        }).then((response)=>{
            document.getElementById("course-form").reset();
            getCourses();
        });
   
}

function updateCourse(id){
    fetch(`http://localhost:8080/courses/${id}`,{
        method:"GET"
    })
    .then(response=>response.json()).then(courseData=>{
    document.getElementById("id").value=courseData.id;
    document.getElementById("id").readOnly=true;
       document.getElementById("name").value=courseData.name;
       document.getElementById("code").value=courseData.code;
       document.getElementById("button").innerHTML=`<button class="btn btn-primary form-control " onclick="saveCourse()">Update Course</button>`;
       document.getElementById("update").value=1
    });
}
