document.addEventListener('DOMContentLoaded', function() {
    // Configuração da exclusão
    document.querySelectorAll('.excluir').forEach(button => {
        button.addEventListener('click', function() {

            if (confirm('Tem certeza que deseja excluir este médico permanentemente?')) {

                const row = this.closest('tr'); // Obtém a linha atual da tabela
                const medicoId = this.dataset.medicoId;
               fetch(`/medico/${medicoId}`, {
                    method: 'DELETE',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    }
                })
                .then(response => {
                    if (response.ok) {
                        alert('Médico excluído com sucesso!');
                        window.location.reload();
                    } else {
                        response.json().then(data => {
                            alert('Erro: ' + (data.message || 'Falha ao excluir médico'));
                        });
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Erro na comunicação com o servidor');
                });
            }
        });
    });
});