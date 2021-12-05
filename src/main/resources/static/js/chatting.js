$(document).ready(function() {

    const websocket = new WebSocket("ws://localhost:8080/ws/chat");

    $("#btn-send").on("click", () => {
        send();
    });

    websocket.onmessage = onMessage;
    websocket.onopen = onOpen;
    websocket.onclose = onClose;

    function send() {

        let msg = document.getElementById("msg");

        websocket.send(msg.value);
        msg.value = "";
    }

    //채팅창에서 나갔을 때
    function onClose() {
        let str = "님이 방을 나가셨습니다.";
        websocket.send(str);
    }

    //채팅창에 들어왔을 때
    function onOpen() {
        let str = "님이 입장하셨습니다.";
        websocket.send(str);
    }

    function onMessage(msg) {
        let data = msg.data;

        console.log(data)
        let str = `<li class="list-group-item">${data}</li>`
        $("#msg-area").append(str);
    }
})
