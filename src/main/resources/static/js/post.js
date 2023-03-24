const apiUrl = '/api/posts';

// 게시글 목록을 가져오는 함수
function fetchPosts() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(posts => {
            const postList = document.getElementById('postList');
            postList.innerHTML = '';

            // 게시글 목록을 출력
            posts.forEach(post => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
          <td>${post.id}</td>
          <td>${post.title}</td>
          <td>${post.content}</td>
          <td>${new Date(post.createdAt).toLocaleDateString()}</td>
          <td>${new Date(post.updatedAt).toLocaleDateString()}</td>
          <td>
            <button onclick="editPost(${post.id})">Edit</button>
            <button onclick="deletePost(${post.id})">Delete</button>
          </td>
        `;
                postList.appendChild(tr);
            });
        })
        .catch(error => console.error(error));
}

// 게시글 생성 함수
function createPost(post) {
    return fetch(apiUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(post)
    }).then(response => response.json());
}

// 게시글 수정 함수
function updatePost(post) {
    return fetch(`${apiUrl}/${post.id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(post)
    }).then(response => response.json());
}

// 게시글 삭제 함수
function deletePost(postId) {
    fetch(`${apiUrl}/${postId}`, {
        method: 'DELETE'
    })
        .then(() => {
            // 게시글 목록 새로고침
            fetchPosts();
        })
        .catch(error => console.error(error));
}

// 게시글 수정을 위해 게시글 정보를 가져오는 함수
function editPost(postId) {
    fetch(`${apiUrl}/${postId}`)
        .then(response => response.json())
        .then(post => {
            // 게시글 입력 폼에 게시글 정보 채우기
            const postIdInput = document.getElementById('postId');
            const titleInput = document.getElementById('title');
            const contentInput = document.getElementById('content');
            postIdInput.value = post.id;
            titleInput.value = post.title;
            contentInput.value = post.content;
        })
        .catch(error => console.error(error));
}

// 게시글 등록 이벤트 처리
const postForm = document.getElementById('postForm');
postForm.addEventListener('submit', e => {
    e.preventDefault();

    const postIdInput = document.getElementById('postId');
    const titleInput = document.getElementById('title');
    const contentInput = document.getElementById('content');

    const post = {
        id: postIdInput.value,
        title: titleInput.value,
        content: contentInput.value
    };

    // 게시글 생성 또는 수정 후, 게시글 목록 새로고침
    (post.id ? updatePost(post) : createPost(post))
        .then(() => {
            postIdInput.value = '';
            titleInput.value = '';
            contentInput.value = '';
            fetchPosts();
        })
        .catch(error => console.error(error));
});

// 페이지 로드 시 게시글 목록 새로고침
fetchPosts();