var inputSearch = document.getElementById("buscarPelicula");
inputSearch.onkeydown = function(e){
    if(e.keyCode == 13){
        document.getElementById("searchForm").submit();
    }
};