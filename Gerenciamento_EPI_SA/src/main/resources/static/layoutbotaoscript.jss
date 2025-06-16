<script>
document.addEventListener('DOMContentLoaded', function() {
    document.querySelectorAll('[data-bs-toggle="modal"]').forEach(button => {
        button.addEventListener('click', function() {
            const modalId = this.getAttribute('data-bs-target');
            const modal = document.querySelector(modalId);
            modal.addEventListener('shown.bs.modal', function() {
                this.querySelector('.btn-secondary').focus();
            });
        });
    });
});
</script>