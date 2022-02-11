# CraJNI
Rust를 Kotlin으로 작성된 Minecraft 플러그인에 붙혀 쓴다는 미친 발상

# 개요
방대한 Rust의 라이브러리와 Native언어의 속도를 마인크래프트 플러그인에서 이용하기 위한 템플릿입니다.

# 빌드
이걸 할 사람이 있겠냐만은 src/main/rust를 cargo build로 빌드하여 얻은 rust.so(dll)을 적당히 어디 넣고 gradle build로 빌드된 CraJNI.jar을 plugins 폴더에 넣은 Bukkit계열 서버에서 rust.so(dll)을 -Djava로 링크하여 실행하면 됩니다.

아래 참조

```bash
java -jar -Djava.library.path=/home/zlfn/IdeaProjects/CraJNI/src/main/rust/target/debug spigot* -nogui

```
