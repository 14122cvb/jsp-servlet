<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Tools Shop - Contact</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="css/style.css" />

<script type="text/javascript" src="js/boxOver.js"></script>
<script>
PositionX = 100;
PositionY = 100;
defaultWidth  = 500;
defaultHeight = 500;
var AutoClose = true;
if (parseInt(navigator.appVersion.charAt(0))>=4){
var isNN=(navigator.appName=="Netscape")?1:0;
var isIE=(navigator.appName.indexOf("Microsoft")!=-1)?1:0;}
var optNN='scrollbars=no,width='+defaultWidth+',height='+defaultHeight+',left='+PositionX+',top='+PositionY;
var optIE='scrollbars=no,width=150,height=100,left='+PositionX+',top='+PositionY;
function popImage(imageURL,imageTitle){
if (isNN){imgWin=window.open('about:blank','',optNN);}
if (isIE){imgWin=window.open('about:blank','',optIE);}
with (imgWin.document){
writeln('<html><head><title>Loading...</title><style>body{margin:0px;}</style>');writeln('<sc'+'ript>');
writeln('var isNN,isIE;');writeln('if (parseInt(navigator.appVersion.charAt(0))>=4){');
writeln('isNN=(navigator.appName=="Netscape")?1:0;');writeln('isIE=(navigator.appName.indexOf("Microsoft")!=-1)?1:0;}');
writeln('function reSizeToImage(){');writeln('if (isIE){');writeln('window.resizeTo(300,300);');
writeln('width=300-(document.body.clientWidth-document.images[0].width);');
writeln('height=300-(document.body.clientHeight-document.images[0].height);');
writeln('window.resizeTo(width,height);}');writeln('if (isNN){');       
writeln('window.innerWidth=document.images["George"].width;');writeln('window.innerHeight=document.images["George"].height;}}');
writeln('function doTitle(){document.title="'+imageTitle+'";}');writeln('</sc'+'ript>');
if (!AutoClose) writeln('</head><body bgcolor=ffffff scroll="no" onload="reSizeToImage();doTitle();self.focus()">')
else writeln('</head><body bgcolor=ffffff scroll="no" onload="reSizeToImage();doTitle();self.focus()" onblur="self.close()">');
writeln('<img name="George" src='+imageURL+' style="display:block"><div align=center>This template  downloaded form <a href='#'>free website templates</a></div></body></html>');
close();		
}}
</script>
</head>
<body>
<div id="main_container">
  <div id="header">
    <div class="top_right">
      <div class="languages">
        <div class="lang_text">Ngôn ngữ:</div>
        <a href="#" class="lang"><img src="images/en.gif" alt="" border="0" /></a> <a href="#" class="lang"><img src="images/de.gif" alt="" border="0" /></a> </div>
      <div class="big_banner"> <a href="#"><img src="images/banner728.jpg" alt="" border="0" /></a> </div>
    </div>
    <div id="logo"> <a href="#"><img src="images/logo.png" alt="" border="0" width="182" height="85" /></a> </div>
  </div>
  <div id="main_content">
    <div id="menu_tab">
      <ul class="menu">
        <li><a href="#" class="nav"> Trang chủ </a></li>
        <li class="divider"></li>
        <li><a href="#" class="nav">Sản phẩm</a></li>
        <li class="divider"></li>
        <li><a href="#" class="nav">Tài khoản</a></li>
        <li class="divider"></li>
        <li><a href="#" class="nav">Đăng kí</a></li>
        <li class="divider"></li>
        <li><a href="#" class="nav">Mua hàng </a></li>
        <li class="divider"></li>
        <li><a href="contact.html" class="nav">Liên hệ</a></li>
        <li class="divider"></li>
        <li><a href="details.html" class="nav">Chi tiết</a></li>
      </ul>
    </div>
    <!-- end of menu tab -->
    <div class="crumb_navigation"> Trang hiện tại: <span class="current">Trang chủ</span> </div>
    <div class="left_content">
      <div class="title_box">Danh mục</div>
      <ul class="left_menu">
        <li class="odd"><a href="#">Dụng cụ điện</a></li>
        <li class="even"><a href="#">Dụng cụ mộc</a></li>
        <li class="odd"><a href="#">Dụng cụ nông nghiệp</a></li>
        <li class="even"><a href="#">Công gia đình</a></li>
        <li class="odd"><a href="#">Dụng cụ nấu ăn</a></li>
        <li class="even"><a href="#">Dụng cụ thể thao</a></li>
        <li class="odd"><a href="#">Quần áo bảo hộ</a></li>
        <li class="even"><a href="#">Dụng cụ khoan cắt</a></li>
        <li class="even"><a href="#">Ốc vít</a></li>
      </ul>
      <div class="title_box">Sản phẩm tiêu biểu</div>
      <div class="border_box">
        <div class="product_title"><a href="#">Makita 156 MX-VL</a></div>
        <div class="product_img"><a href="#"><img src="images/p1.jpg" alt="" border="0" /></a></div>
        <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>
      <div class="title_box">Liên lạc</div>
      <div class="border_box">
        <input type="text" name="newsletter" class="newsletter_input" value="your email"/>
        <a href="#" class="join">Gửi</a> </div>
      <div class="banner_adds"> <a href="#"><img src="images/bann2.jpg" alt="" border="0" /></a> </div>
    </div>
    <!-- end of left content -->
    <div class="center_content">
      <div class="center_title_bar">Liên hệ với chúng tôi</div>
      <div class="prod_box_big">
        <div class="center_prod_box_big">
          <div class="contact_form">
            <div class="form_row">
              <label class="contact"><strong>Họ và tên:</strong></label>
              <input type="text" class="contact_input" />
            </div>
            <div class="form_row">
              <label class="contact"><strong>Email:</strong></label>
              <input type="text" class="contact_input" />
            </div>
            <div class="form_row">
              <label class="contact"><strong>Điện thoại:</strong></label>
              <input type="text" class="contact_input" />
            </div>
            <div class="form_row">
              <label class="contact"><strong>Công ty:</strong></label>
              <input type="text" class="contact_input" />
            </div>
            <div class="form_row">
              <label class="contact"><strong>Ý kiến:</strong></label>
              <textarea class="contact_textarea" ></textarea>
            </div>
            <div class="form_row"> <a href="#" class="prod_details">Gửi</a> </div>
          </div>
        </div>
      </div>
    </div>
    <!-- end of center content -->
    <div class="right_content">
      <div class="title_box">Tìm kiếm</div>
      <div class="border_box">
        <input type="text" name="newsletter" class="newsletter_input" value="keyword"/>
        <a href="#" class="join">Tìm</a> </div>
      <div class="shopping_cart">
        <div class="title_box">Giỏ hàng của bạn</div>
        <div class="cart_details"> 3 items <br />
          <span class="border_cart"></span> Tổng: <span class="price">350$</span> </div>
        <div class="cart_icon"><a href="#"><img src="images/shoppingcart.png" alt="" width="35" height="35" border="0" /></a></div>
      </div>
      <div class="title_box">Tin mới</div>
      <div class="border_box">
        <div class="product_title"><a href="#">Motorola 156 MX-VL</a></div>
        <div class="product_img"><a href="#"><img src="images/p2.jpg" alt="" border="0" /></a></div>
        <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>
      <div class="title_box">Nhà sản xuất</div>
      <ul class="left_menu">
        <li class="odd"><a href="#">Bosch</a></li>
        <li class="even"><a href="#">Samsung</a></li>
        <li class="odd"><a href="#">Makita</a></li>
        <li class="even"><a href="#">LG</a></li>
        <li class="odd"><a href="#">Fujitsu Siemens</a></li>
        <li class="even"><a href="#">Motorola</a></li>
        <li class="odd"><a href="#">Phillips</a></li>
        <li class="even"><a href="#">Beko</a></li>
      </ul>
      <div class="banner_adds"> <a href="#"><img src="images/bann1.jpg" alt="" border="0" /></a> </div>
    </div>
    <!-- end of right content -->
  </div>
  <!-- end of main content -->
  <div class="footer">
    <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="89" height="42"/> </div>
    <div class="center_footer"> Công ty xuất nhập khẩu vTools 2014<br />
      <a href="http://csscreme.com"><img src="images/csscreme.jpg" alt="csscreme" title="csscreme" border="0" /></a><br />
      <img src="images/payment.gif" alt="" /> </div>
    <div class="right_footer"> <a href="#">Trang chủ</a> <a href="#">Trợ giúp</a><a href="#">Liên hệ</a> <a href="#">Chi tiết</a> </div>
  </div>
</div>
<!-- end of main_container -->
<div align=center></div></body>
</html>
