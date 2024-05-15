document.getElementById('file-upload').addEventListener('change', function() {
    const fileName = this.files[0].name;
    document.getElementById('file-name').textContent = `選択されたファイル: ${fileName}`;
});
