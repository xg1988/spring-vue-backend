import axiosInstance from "../axios";

export async function checkLogin(){
    //return isValuePresent(getCookie('JWT_TOKEN'))
    const response = await axiosInstance.get('/user-info');
    console.log(response) 

    return response.data
}
// 쿠키에서 값 가져오기
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

function isValuePresent(value) {
    console.log('value : ' + value)
  return value !== undefined && value !== null && value !== '';
}
