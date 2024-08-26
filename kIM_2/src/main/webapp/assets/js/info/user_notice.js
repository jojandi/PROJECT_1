 function filterTable() {
            const input = document.getElementById('searchInput');
            const filter = input.value.toLowerCase();
            const table = document.getElementById('reportTable');
            const tr = table.getElementsByTagName('tr');

            for (let i = 1; i < tr.length; i++) {
                const tdArray = tr[i].getElementsByTagName('td');
                let match = false;
                for (let j = 0; j < tdArray.length; j++) {
                    if (tdArray[j]) {
                        if (tdArray[j].innerHTML.toLowerCase().indexOf(filter) > -1) {
                            match = true;
                            break;
                        }
                    }
                }
                tr[i].style.display = match ? '' : 'none';
            }
        }
   