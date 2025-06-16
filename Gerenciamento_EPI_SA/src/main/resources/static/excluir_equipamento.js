document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('.excluir').forEach(button => {
        button.addEventListener('click', function() {
            const equipamentoId = this.getAttribute('data-equipamento-id');

            if (confirm('Tem certeza que deseja excluir este equipamento?')) {
                fetch(`/equipamento/${equipamentoId}`, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json',
                        'X-CSRF-TOKEN': document.querySelector('meta[name="_csrf"]').content
                    }
                })
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    }
                    return response.text().then(text => { throw new Error(text) });
                })
                .then(message => {
                    alert(message);
                    window.location.reload();
                })
                .catch(error => {
                    alert(error.message);
                });
            }
        });
    });
});