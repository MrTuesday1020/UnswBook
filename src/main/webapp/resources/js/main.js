function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#imgInp").change(function(){
    readURL(this);
});


function isEveryInputEmpty() {
	var agency = document.getElementById("agency").value;
	var headline = document.getElementById("headline").value;
	var date = document.getElementById("date").value;
	var city = document.getElementById("city").value;
	var content_seasrch = document.getElementById("content_seasrch").value;
	
	if( agency == "" && headline == "" && date == "" && city == "" && content_seasrch == ""){
		alert("Please input something!")
		return false;
	}
	return true;
}
