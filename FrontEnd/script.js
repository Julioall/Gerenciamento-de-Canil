let racas = [
    {
        nome: "Akita"
    },
    {
        nome: "Buldogue"
    },
    {
        nome: "Boxer"
    },
    {
        nome: "Golden Retriever"
    },
    {
        nome: "Labrador"
    },
    {
        nome: "Pastor Alemão"
    },
    {
        nome: "Pinscher"
    },
    {
        nome: "Poodle"
    }
];

let caes = [
    {
        nome: "Bob",
        raca: "Poodle"
    },
    {
        nome: "Bolinha",
        raca: "Pastor Alemão"
    },
    {
        nome: "Lilica",
        raca: "Pinscher"
    },
    {
        nome: "Thor",
        raca: "Labrador"
    },
    {
        nome: "Yuumi",
        raca: "Akita"
    }
];

function carregarRacas() {
    let table = document.getElementById('dados');

    racas.forEach(raca => {
        let tr = document.createElement('tr');
        let td = document.createElement('td');
        td.innerHTML = raca.nome;
        tr.appendChild(td);
        table.appendChild(tr);
    });
}

function adicionarRaca(e) {
    e.preventDefault();

    let input = document.getElementById('input-raca');
    if(input.value.length == 0) return alert('Nome da raça não pode estar vazio!');

    let table = document.getElementById('dados');
    let tr = document.createElement('tr');
    let td = document.createElement('td');
    td.innerHTML = input.value;
    tr.appendChild(td);
    table.appendChild(tr);
    input.value = '';

    setTimeout(() => {
        alert('Raça inserida com sucesso!');
    }, 100);
}

function carregarCaes() {
    let table = document.getElementById('dados');
    let select = document.getElementById('input-raca');

    caes.forEach(cao => {
        let tr = document.createElement('tr');
        let td1 = document.createElement('td');
        let td2 = document.createElement('td');
        td1.innerHTML = cao.nome;
        td2.innerHTML = cao.raca;
        tr.appendChild(td1);
        tr.appendChild(td2);
        table.appendChild(tr);
    });

    
    racas.forEach(raca => {
        let option = document.createElement('option');
        option.innerHTML = raca.nome;
        select.appendChild(option);
    });
}

function adicionarCao(e) {
    e.preventDefault();

    let input = document.getElementById('input-nome');
    if(input.value.length == 0) return alert('Nome do cão não pode estar vazio!');

    let select = document.getElementById('input-raca');
    if(select.value.length == 0) return alert('Selecione uma raça!');

    let table = document.getElementById('dados');
    let tr = document.createElement('tr');
    let td1 = document.createElement('td');
    let td2 = document.createElement('td');
    td1.innerHTML = input.value;
    td2.innerHTML = select.value;
    tr.appendChild(td1);
    tr.appendChild(td2);
    table.appendChild(tr);
    input.value = '';
    select.value = '';

    setTimeout(() => {
        alert('Cão inserido com sucesso!');
    }, 100);
}