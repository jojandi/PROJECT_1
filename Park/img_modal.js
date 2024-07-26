
    document.addEventListener("DOMContentLoaded", function() {
        const modal = document.getElementById("modal");
        const modalImg = document.getElementById("modal-img");
        const span = document.getElementsByClassName("close")[0];
    
        const defectImages = {
            "page-damage": "https://via.placeholder.com/700x400?text=Cover+Damage",
            "cover-damage": "https://via.placeholder.com/700x400?text=Cover+Damage",
            "page-missing": "https://via.placeholder.com/700x400?text=Page+Missing",
            "page-contamination": "https://via.placeholder.com/700x400?text=Page+Contamination"
        };
    
        const defectTypes = document.querySelectorAll(".defect-type");
        defectTypes.forEach(function(defectType) {
            defectType.addEventListener("click", function() {
                const type = defectType.getAttribute("data-type");
                modal.style.display = "block";
                modalImg.src = defectImages[type];
            });
        });
    
        span.onclick = function() {
            modal.style.display = "none";
        };
    
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        };
    });
