window.onload = function () {

    const subscribers = [];

    const genres = ['언론', '소설', '역사', '과학', '인문학', '자기계발', '만화', '판타지', '일반', '학술논문', '오디오', '무협', '로맨스'];

    const books = [
        { title: 'THE MONEY BOOK(더 머니북)', author: '토스', publisher: '비바리퍼블리카', genre: '일반', cover: 'https://media.discordapp.net/attachments/1128320143232077876/1264791198460018788/2024-07-22_12.48.09.png?ex=669f2818&is=669dd698&hm=e79f29d8cc3b9cbacc6c9e39071ac98c7c42e6cb53569a9f40d1a728db010fa5&=&format=webp&quality=lossless&width=544&height=864' },
        { title: '그의 운명에 대한 아주 개인적인 생각', author: '유시민', publisher: '생각의길', genre: '언론', cover: 'https://media.discordapp.net/attachments/1128320143232077876/1264791577620910201/2024-07-22_12.48.51.png?ex=669fd132&is=669e7fb2&hm=6cb68c5b6d8771419f5b56aca33b8bee36df655489426ce9823021a13716aeac&=&format=webp&quality=lossless&width=532&height=816' },
        { title: '만일 나에게 단 한 번의 아침이 남아 있다면', author: '존 릴런드', publisher: '북모먼트', genre: '소설', cover: 'https://media.discordapp.net/attachments/1128320143232077876/1264791606620590110/2024-07-22_12.49.05.png?ex=669fd139&is=669e7fb9&hm=919093274af16fb216b9d320310ebd3367567fc4d2feb2ef46108356c1724839&=&format=webp&quality=lossless&width=544&height=824' },
        { title: '나는 도대체 왜 피곤할까', author: '에이미 샤', publisher: '북플레저', genre: '인문학', cover: 'https://media.discordapp.net/attachments/1128320143232077876/1264791631220183111/2024-07-22_12.49.23.png?ex=669fd13f&is=669e7fbf&hm=b649683c152ea47eb5a6007bed1dbecc0ac28a10d87bd8c5f1062c1772f432c7&=&format=webp&quality=lossless&width=540&height=792' },
        { title: '챔피언처럼 생각하고 거래하라', author: '마크 미너비니', publisher: '이레미디어', genre: '자기계발', cover: 'https://media.discordapp.net/attachments/1128320143232077876/1264791649322537113/2024-07-22_12.49.35.png?ex=669fd143&is=669e7fc3&hm=b3c73f461aebfe9b626ca70f20c9e66537513c28726f3b90b6fe2e640caa96a4&=&format=webp&quality=lossless&width=458&height=700' },
        { title: '1등급 만들기 고등 통합사회 1000제 기출 분석', author: '미래엔에듀 편집부', publisher: '미래엔에듀', genre: '자기계발', cover: 'https://cdn.discordapp.com/attachments/1128320143232077876/1265330029605425282/2024-07-24_12.26.42.png?ex=66a11deb&is=669fcc6b&hm=b95d84ad5654fe99c7443a95a3a392fc233d459166006e4c8fdacf05aea490be&' },
        { title: '군주론', author: '이제섭', publisher: '휴먼출판사', genre: '학술논문', cover: 'https://cdn.discordapp.com/attachments/1128320143232077876/1265330030570115103/2024-07-24_12.27.20.png?ex=66a11deb&is=669fcc6b&hm=8321a9a85f687db1ebb2282718ef07537eb13d368db78d5bf53826cd396aa207&' },
        { title: '판타지의 세계', author: '김철수', publisher: '판타지출판사', genre: '오디오', cover: 'https://cdn.discordapp.com/attachments/1128320143232077876/1265545241394548816/2024-07-24_2.44.35.png?ex=66a337da&is=66a1e65a&hm=bd55716c41add98c855f455ffaa7714fb6f6a1a4f18ed6366e9a7007f65647cb&' },
        { title: '무협의 나라', author: '민주아', publisher: '무협출판사', genre: '무협', cover: 'https://cdn.discordapp.com/attachments/1128320143232077876/1265545241394548816/2024-07-24_2.44.35.png?ex=66a337da&is=66a1e65a&hm=bd55716c41add98c855f455ffaa7714fb6f6a1a4f18ed6366e9a7007f65647cb&' },
        { title: '돈의 심리학', author: '이제섭', publisher: '이제섭출판사', genre: '로맨스', cover: 'https://cdn.discordapp.com/attachments/1128320143232077876/1265545241394548816/2024-07-24_2.44.35.png?ex=66a337da&is=66a1e65a&hm=bd55716c41add98c855f455ffaa7714fb6f6a1a4f18ed6366e9a7007f65647cb&' }
    ];


    function getRandomAge() {
        return Math.floor(Math.random() * 41) + 10;
    }


    function getRandomGender() {
        return Math.random() < 0.5 ? '남성' : '여성';
    }


    function getRandomGenre() {
        return genres[Math.floor(Math.random() * genres.length)];
    }


    function showRecommendations(subscriberIndex) {
        const popup = document.getElementById('recommendationPopup');
        popup.style.display = 'block';


        const book1 = books[Math.floor(Math.random() * books.length)];
        document.getElementById('book1').innerHTML = `
        <img src="${book1.cover}" alt="책 표지">
        <p><strong>도서명:</strong> ${book1.title}</p>
        <p><strong>저자:</strong> ${book1.author}</p>
        <p><strong>출판사:</strong> ${book1.publisher}</p>
        <p><strong>장르:</strong> ${book1.genre}</p>
    `;

        let book2;
        do {
            book2 = books[Math.floor(Math.random() * books.length)];
        } while (book2 === book1);

        document.getElementById('book2').innerHTML = `
        <img src="${book2.cover}" alt="책 표지">
        <p><strong>도서명:</strong> ${book2.title}</p>
        <p><strong>저자:</strong> ${book2.author}</p>
        <p><strong>출판사:</strong> ${book2.publisher}</p>
        <p><strong>장르:</strong> ${book2.genre}</p>
    `;
    }


    function closePopup() {
        const popup = document.getElementById('recommendationPopup');
        popup.style.display = 'none';
    }


    function addSubscriber() {
        const table = document.getElementById('memberData');
        const newRow = table.insertRow();

        const name = generateRandomName();
        const gender = getRandomGender();
        const age = getRandomAge();
        const genre = getRandomGenre();


        subscribers.push({ name, gender, age, genre });


        const cell1 = newRow.insertCell(0);
        const cell2 = newRow.insertCell(1);
        const cell3 = newRow.insertCell(2);
        const cell4 = newRow.insertCell(3);
        const cell5 = newRow.insertCell(4);


        cell1.textContent = name;
        cell2.textContent = gender;
        cell3.textContent = age;
        cell4.textContent = genre;


        const recommendButton = document.createElement('button');
        recommendButton.textContent = '구독 도서 추천';
        recommendButton.addEventListener('click', function () {
            showRecommendations(subscribers.length - 1);
        });
        cell5.appendChild(recommendButton);
    }

    function generateRandomName() {
        const Names = ['이제섭', '박규태', '김아영', '조민정', '조잔디', '섭제이', '태규박', '영아김', '기희서', '방국봉', '봉주르', '토게피', '파이리', '피존투', '야도란', '민주아'
            , '포켓몬', '김승환', '김환승', '승김환', '제섭이', '규태박', '아영김', '민정조', '조정민', '김범수', '박효신', '들국화', '박완규', '죽겠다', '너무나', '힘들어', '이름을', '생각하', '기가너', '무힘들', '어용이',
            '이을용', '황선홍', '송중기', '피카츄', '라이츄', '김국태', '준수현', '현준수'
        ];
        const Name = Names[Math.floor(Math.random() * Names.length)];
        return `${Name}`;
    }

    for (let i = 0; i < 20; i++) {
        addSubscriber();
    }
}