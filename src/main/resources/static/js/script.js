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

        // Adiciona a resposta do bot
        const botMessage = document.createElement('div');
        botMessage.className = 'bot-message';
        botMessage.textContent = 'Esta é uma resposta do bot.';
        chatBody.appendChild(botMessage);

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

// Adiciona a mensagem inicial quando a página é carregada
addInitialMessage();
