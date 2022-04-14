function updateStudent(id, name, email, password) {
  document.getElementById("modalUpdateForm").action = "/student/update/" + id;
  document.getElementById("modalUpdateInputName").value = name;
  document.getElementById("modalUpdateInputEmail").value = email;
  document.getElementById("modalUpdateInputPassword").value = password;
}


function updateTeacher(id,name,email,curricularUnit){
  document.getElementById("modalUpdateFormTeacher").action = "/teachers/update/" + id;
  document.getElementById("modalUpdateInputName").value = name;
  document.getElementById("modalUpdateInputEmail").value = email;
  document.getElementById("modalUpdateInputcurricularUnit").value = curricularUnit;
}