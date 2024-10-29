<template>
	<div>
		<div class="sub-title">설정</div>
		<div class="profile-container">
			<img src="https://via.placeholder.com/80" alt="프로필 이미지" />
			<div class="profile-info">
				<h2>홍길동</h2>
				<p>안녕하세요! 환영합니다.</p>
			</div>
		</div>

		<div class="button-container">
			<a href="#" class="button">
				<img src="https://via.placeholder.com/30" alt="아이콘" />
				<div class="text">
					<h3>내 정보</h3>
					<p>개인 정보 및 설정</p>
				</div>
				<div class="arrow">&#9654;</div>
			</a>
			<a href="#" class="button">
				<img src="https://via.placeholder.com/30" alt="아이콘" />
				<div class="text">
					<h3>내 거래</h3>
					<p>거래 내역 확인</p>
				</div>
				<div class="arrow">&#9654;</div>
			</a>
			<a href="#" class="button">
				<img src="https://via.placeholder.com/30" alt="아이콘" />
				<div class="text">
					<h3>알림</h3>
					<p>알림 및 메시지</p>
				</div>
				<div class="arrow">&#9654;</div>
			</a>
			<a href="#" class="button">
				<img src="https://via.placeholder.com/30" alt="아이콘" />
				<div class="text">
					<h3>설정</h3>
					<p>앱 설정 및 도움말</p>
				</div>
				<div class="arrow">&#9654;</div>
			</a>
		</div>
	</div>
</template>

<script>
export default {};
</script>

<style>
.profile-container {
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 20px;
	background-color: #fff;
	border-bottom: 1px solid #ddd;
}
.profile-container img {
	width: 80px;
	height: 80px;
	border-radius: 50%;
	margin-right: 20px;
}
.profile-info {
	flex: 1;
}
.profile-info h2 {
	margin: 0;
	font-size: 20px;
	color: #333;
}
.profile-info p {
	margin: 5px 0 0;
	color: #666;
}
.button-container {
	max-width: 800px;
	margin: 20px auto;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	padding: 20px;
}
.button {
	display: flex;
	align-items: center;
	padding: 15px;
	border-bottom: 1px solid #ddd;
	text-decoration: none;
	color: #333;
	transition: background-color 0.3s;
}
.button:last-child {
	border-bottom: none;
}
.button:hover {
	background-color: #f9f9f9;
}
.button img {
	width: 30px;
	height: 30px;
	margin-right: 15px;
}
.button .text {
	flex: 1;
}
.button .text h3 {
	margin: 0;
	font-size: 16px;
}
.button .text p {
	margin: 5px 0 0;
	font-size: 14px;
	color: #666;
}
.button .arrow {
	font-size: 18px;
	color: #999;
}
</style>
