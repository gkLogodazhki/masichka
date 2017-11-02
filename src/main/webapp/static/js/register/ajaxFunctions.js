function refreshSecurityCode() {
    $.get("http://localhost:8080/masichka/SecurityCode"
        , function (data) {
            $('#code-generator').html(data);
        });
}

function isCorrectSecurityCode() {
    var $input = $("[name='userSecutityCode']").val();
    if ($input.length === 8) {
        var $security = $('#code-generator').html();
        $.get("http://localhost:8080/masichka/CheckSecurityCode?securityCode="
            + $security + "&input=" + $input, function (data) {
            $('#security-code-message').css("display", "inline-block");
            if (data) {
                $('#security-code-message').addClass('glyphicon glyphicon-ok');
            }
            else {
                $('#security-code-message').addClass('glyphicon glyphicon-remove');
            }
        });
    } else {
        $('#security-code-message').css("display", "none");
        $('#security-code-message').removeClass();
    }
}

function checkPassword() {
    $('#password-message').removeClass();
    var $user_pass = $("[name='user_password']").val();
    if ($user_pass.length !== 0) {
        var $confirm_pass = $("[name='confirm_password']").val();
        $.get("http://localhost:8080/masichka/CheckPassword?user_pass="
            + $user_pass + "&confirm_pass=" + $confirm_pass, function (data) {
            $('#password-message').css("display", "inline-block");
            if (data) {
                $('#password-message').addClass('glyphicon glyphicon-ok');
            }
            else {
                $('#password-message').addClass('glyphicon glyphicon-remove');
            }
        });
    }
}

function phoneCode() {
    var $contact_no = $("[name='contact_no']").val();
    $contact_no = $contact_no.replace(/{|}|\||\\/, " ");
    if (!$contact_no.startsWith("(+359)")) {
        $.get("http://localhost:8080/masichka/PhoneCode?contact_no=" + $contact_no, function (data) {
            $("[name='contact_no']").val(data);
        });
    }
}

function checkForAlphabetic() {
    var $contact_no = $("[name='contact_no']").val();
    $contact_no = $contact_no.replace(/{|}|\||\\/, " ");
    $.get("http://localhost:8080/masichka/CheckAlphabetics?contact_no=" + $contact_no, function (data) {
        if ($contact_no !== data) {
            $("[name='contact_no']").val(data);
        }
    });
}

function checkForIllegalName(value) {
    var $name = $("[name='" + value + "']").val();
    $name = $name.replace(/{|}|\||\\/, " ");
    $.get("http://localhost:8080/masichka/CheckName?name=" + $name, function (data) {
        if ($name !== data) {
            $("[name='" + value + "']").val(data);
        }
    });
}

