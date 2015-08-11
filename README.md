# README

Giới thiệu chung

- Project kết hợp springmvc - hibernate - oracle sử dụng cho các dự án nhỏ, toàn bộ cấu hình spring được thực hiện bằng ANOTATION nên tiện lợi và dễ quản lý hơn so với việc sử dụng xml
- Project cũng có nhiều custom cấu hình liên quan đến kết nối csdl (sử dụng connection pool) cũng như custom lại các phần trong spring security để phục vụ việc chứng thực người dùng theo cách tùy biến hơn.
- Các công nghệ sử dụng trong project
	[springmvc4](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)
	[hibernate](http://hibernate.org)
	[hikaricp](https://github.com/brettwooldridge/HikariCP)
	[reactjs](http://facebook.github.io/react)
- Phần hỗ trợ
	[gruntjs](http://gruntjs.com)

Hướng dẫn cài đặt project

### Phiên bản

* Version 1.0


### [Mới cập nhập] Đặc biệt chú ý
* Nên chạy grunt watch mỗi khi code reactjs
* Nên mở song song file react.js ở thư mục build vì phải save as file này ở netbean thì nó mới cập nhập vào war

### [Mới cập nhập] Hướng dẫn sử dụng git, các lệnh cơ bản
* Git là công cụ quản lý source code tương tự svn, điểm khác biệt lớn nhất giữa svn và git: code được đẩy lên 1 vùng đệm (local) nằm ở máy người dùng sau đó mới đẩy lên server (không như svn là đẩy trực tiếp code lên server) điểm này khiến cho việc commit code sẽ nhiều hơn 1 bước so với khi sử dụng svn
* Các lệnh cơ bản
     * Loại bỏ toàn bộ các phần đã chỉnh sửa đưa code về phiên bản vừa cập nhập về
                
           git reset —hard

    
    * Đẩy code lên vùng đệm dưới local
            
            
          git add -A
          git commit -m "Mô tả cho thay đổi trong code"
          
          
    
    * Đẩy code lên server
    
    
          git push origin master
          
          
    
    * Cập nhập code
    
    
          git pull origin master
          
          
    
    * Một vài chú ý
    
    
        * Về cơ bản là không có công cụ khi xẩy ra conflict, nhưng có conflict thì edit dễ hơn svn (notepad++)
        * Đôi khi không thể push code lên được (vì server có thay đổi, cái này cũng như svn thôi, phải pull về trước đã)
        * Phải đẩy code lên vùng đệm ở local thì mới push lên server được
        * Ngoài git add -A thì có thể thêm từng file kiểu 
                    
                    
              git add /path/to/file/temp.java
                
        
        * NÊN SỬ DỤNG SOURCE TREE
       

### [Mới cập nhập] Cài đặt và cấu hình Grunt để tự động build các file js và jsx viết bằng React

* Cài đặt [nodejs](http://nodejs.org/)
* Bật CMD và tiến hành các cài đặt sau:

	* Sau khi cài đặt nodejs thì tiến hành cài đặt Grunt, chú ý proxy
		
            #npm config set proxy http://10.60.15.84:8084
            #npm config set https-proxy http://10.60.15.84:8084
            npm install grunt-cli -g

	* Sau khi cài đặt Grunt thì tiến hành cài đặt các component

			cd to/path/calendar
			npm install grunt --save-dev
			npm install grunt-react --save-dev
			npm install grunt-contrib-clean --save-dev
			npm install grunt-contrib-watch --save-dev
			npm install grunt-browserify --save-dev

	* Sau đó để build file js thì chạy 
		
			grunt 

	* Nếu muốn tự động chạy lệnh build này thì trên cửa sổ cmd gõ
	
			grunt watch

### Các công cụ cần thiết?

* [apache-maven-3.2.3](http://maven.apache.org/download.cgi) Hoặc các bản 3.x đều được
* [jdk 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) Hoặc 1.7
* [apache-tomcat-8.0.8](http://tomcat.apache.org/download-80.cgi) Hoặc các phiên bản 7.x
* [MySQL](http://dev.mysql.com/downloads/windows/installer/) CSDL, có thể cài đặt thêm các [công cụ quản lý](http://dev.mysql.com/downloads/calendar/)
* Netbeans IDE lập trình bản 7.x hoặc 8.x
* [Source Tree](http://downloads.atlassian.com/software/sourcetree/windows/SourceTreeSetup_1.6.10.exe) Công cụ để quản lý code
* Lập tài khoản tại [Bitbucket](https://bitbucket.org/) Để phân quyền truy cập vào code

### Cách checkout và commit code với git và Source Tree


### Cài đặt và chạy project 

* Sau khi đã checkout project
* Tìm file calendar.sql trong thư mục /scripts, chạy file này để tạo các bảng trong CSDL !!!CHÚ Ý PHẢI TẠO DB TRƯỚC - calendar, TRONG FILE NÀY KHÔNG CÓ CÂU LỆNH TẠO DB!!!
* Chỉnh lại các thông số cấu hình cho project để phù hợp cài đặt trên máy:

	* Tìm file AppConfig.java -> Hàm BasicDataSource để chính thông tin kết nối đến CSDL
		
	* Tìm file log4j.properties -> log4j.appender.FILE.File để chính đường dẫn đến file log

### Quản lý công việc và thông tin khác 

* [http://www.slicktasks.com/](http://www.slicktasks.com/)

Mọi yêu cầu hỗ trợ, đóng góp ý kiến, donate xin vui lòng mail đến địa chỉ
<mailto:hoanghieptran86@gmail.com>
