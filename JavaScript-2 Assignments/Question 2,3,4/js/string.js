document.getElementById("remove").addEventListener("click", getString);

function getString() {
    var str = document.getElementById("input").value;
    document.getElementById("display").innerHTML=str;
    var prevPos = 0;
    var curPos = 0;
    var curLength = 0;
    while (curPos < str.length) {
        if (str.charAt(prevPos) == str.charAt(curPos)) {
            curPos++;
            curLength++;
        } else if (curLength > 1) {
            str = str.slice(0, prevPos) + str.slice(curPos);
            document.getElementById("display").innerHTML += "-->" + str;
            prevPos = prevPos - 1 > 0 ? prevPos - 1 : 0;
            curPos = prevPos;
            curLength = 0;
        }
        else {
            prevPos = curPos;
            curLength = 0;
        }
    }
    if (curLength > 1) {
        str = str.slice(0, prevPos) + str.slice(curPos, str.length);
    }
 document.getElementById("display").innerHTML += "-->" + str;
}
