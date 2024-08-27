document.getElementById('pdfFile').addEventListener('change', function(event) {
        const file = event.target.files[0];
        if (file) {
            const formData = new FormData();
            formData.append('file', file);

            fetch('/extract-text', {
                method: 'POST',
                body: formData
            })
            .then(response => response.text())
            .then(data => {
                // Divida o texto extraído em linhas
                const lines = data.split('\n');
                
                // A primeira linha vai para o título
                const titulo = lines.length > 0 ? lines[0].trim() : '';

                // As linhas restantes vão para o corpo
                const corpo = lines.slice(1).join('\n').trim();

                // Preencha os campos do formulário
                document.getElementById('titulo').value = titulo;
                document.getElementById('corpo').value = corpo;
            })
            .catch(error => console.error('Erro ao processar o PDF:', error));
        }
    });