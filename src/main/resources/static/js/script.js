document.addEventListener('DOMContentLoaded', function() {
    const chatbotContainer = document.querySelector('.chatbot-container');
    const openChatbotButton = document.createElement('button');
    openChatbotButton.className = 'open-chatbot-button btn btn-primary';
    openChatbotButton.style.position = 'fixed';
    openChatbotButton.style.bottom = '5rem';
    openChatbotButton.style.right = '2rem';
    openChatbotButton.innerHTML = '<i class="bi bi-chat-dots"></i>';

    // Função para abrir o chatbot e esconder o botão
    openChatbotButton.onclick = function() {
        chatbotContainer.style.display = 'block';
        openChatbotButton.style.display = 'none';
    };

    document.body.appendChild(openChatbotButton);

    const closeChatbotButton = document.getElementById('close-chatbot');
    
    // Função para fechar o chatbot e mostrar o botão
    closeChatbotButton.onclick = function() {
        chatbotContainer.style.display = 'none';
        openChatbotButton.style.display = 'block';
    };
});

function sendMessage() {
    const chatBody = document.getElementById('chatbot-body');
    const chatInput = document.getElementById('chatbot-input');
    const message = chatInput.value.trim();

    if (message !== '') {
        // Adiciona a mensagem do usuário
        const userMessage = document.createElement('div');
        userMessage.className = 'user-message';
        userMessage.textContent = message;
        chatBody.appendChild(userMessage);
    	
    	fetch("http://127.0.0.1:8080/llm-completion/llm-call",{
        method: 'POST',
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            content: message
        })
    })
    .then((response) => response.json())
    .then((response) => {
        // Adiciona a resposta do bot
        const botMessage = document.createElement('div');
        botMessage.className = 'bot-message';
        botMessage.innerHTML = formatResponse(JSON.stringify(response));
        chatBody.appendChild(botMessage);
    })
    .catch((e) => {
        console.log(`Error -> ${e}`)
        const botMessage = document.createElement('div');
        botMessage.className = 'bot-message';
        botMessage.textContent = 'Erro tente novamente mais tarde...';
        chatBody.appendChild(botMessage);
    })
        
        // Limpa o campo de entrada
        chatInput.value = '';
        chatBody.scrollTop = chatBody.scrollHeight;
    }
}

// Função para adicionar a mensagem inicial
function addInitialMessage() {
    const chatBody = document.getElementById('chatbot-body');
    const initialMessage = document.createElement('div');
    initialMessage.className = 'bot-message';
    initialMessage.textContent = 'Olá! Como posso ajudar você hoje?';
    chatBody.appendChild(initialMessage);
}

function updateContent(element) {
    var title = element.getAttribute("data-title");
    var description = element.getAttribute("data-description");

    document.getElementById("compliance-title").textContent = title;
    document.getElementById("compliance-description").textContent = description;
}

function formatResponse(response) {
    // Remove a parte indesejada do início e do final
    const formattedResponse = response.substring(13)

    // Formatação adicional
    return formattedResponse
    	.replace(/^"Response":"|"\}$/g, '')
        .replace(/\n/g, '<br>') // Substitui quebras de linha por <br>
        .replace(/(\d+\.\s)/g, '<strong>$1</strong>') // Destaque os números das listas
        .replace(/(\*\*[^*]+\*\*)/g, '<strong>$1</strong>') // Destaque texto entre **
        .replace(/(Recomendo consultar.*)/, '<em>$1</em>'); // Formata a recomendação
}

// Adiciona a mensagem inicial quando a página é carregada
addInitialMessage();
