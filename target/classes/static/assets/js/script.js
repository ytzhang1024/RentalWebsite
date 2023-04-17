// 1. User Feedback
function submitFeedback() {

    $.ajax({
        type: 'POST',
        url: '/feedback/submit',
        async: false,
        data: $("#feedbackForm").serialize(), // Get all parameters under this form
        success: function (data) {
            //if the user does not log in yet then return
            if (data.msg == null || data.msg.indexOf('Login') != -1) {
                $('#gotoLogin').click();
                return;
            }
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}

// 2.Mark
function submitMark(houseId) {
    $.ajax({
        type: 'POST',
        url: '/mark/submit',
        async: false,
        data: {
            "houseId": houseId
        },
        success: function (data) {
            if (data.msg == null || data.msg.indexOf('Login') != -1) {
                $('#gotoLogin').click();
                return;
            }
            alert(data.msg);
        }
    });
}

// 3.Login
function submitLogin() {
    $.ajax({
        type: 'POST',
        url: '/login/submit',
        async: false,
        data: $("#loginForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}


// 4.Sign up
function submitRegister() {
    $.ajax({
        type: 'POST',
        url: '/register/submit',
        async: false,
        data: $("#registerForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}


// 5.Reset password
function submitForget() {
    $.ajax({
        type: 'POST',
        url: '/forget/submit',
        async: false,
        data: $("#forgetForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}


// 5.Save personal info
function submitProfile() {
    $.ajax({
        type: 'POST',
        url: '/admin/profile/submit',
        async: false,
        data: $("#profileForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}


// 6.Save password
function submitPassword() {
    $.ajax({
        type: 'POST',
        url: '/admin/password/submit',
        async: false,
        data: $("#passwordForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}


// 6.Post house
function upHouse(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/house/up',
        async: false,
        data: {
            "id": id
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}

// 7.Remove house
function downHouse(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/house/down',
        async: false,
        data: {
            "id": id
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}


// 8.Delete house
function deleteHouse(id) {
    if (confirm('Are you sure you want to delete the house information?？')) {
        $.ajax({
            type: 'POST',
            url: '/admin/house/delete',
            async: false,
            data: {
                "id": id
            },
            success: function (data) {
                alert(data.msg);
                if (data.code == 200) {
                    window.location.reload();
                }
            }
        });
    }

}


// 9.Cancel mark
function cancelMark(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/mark/cancel',
        async: false,
        data: {
            "id": id
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });

}

// 10.Delete feedback
function deleteFeedback(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/feedback/delete',
        async: false,
        data: {
            "id": id
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });

}

//11. Matching
function submitMatchingInfo() {
    $.ajax({
        type: 'POST',
        url: '/admin/matching/submit',
        async: false,
        data: $("#matchingSubmit").serialize(),
        success: function (data) {
            alert(data.msg);
            // Refresh page
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}

// 12.Feedback update
function feedbackReplySubmit() {
    $.ajax({
        type: 'POST',
        url: '/admin/feedback/reply/submit',
        async: false,
        data: $("#feedbackForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });

}

// 13.Map pop up
function toggleMap() {
    $('#map').toggleClass('active');
}

// 14.Picture pop up
function toggleGallery() {
    $('#gallery').toggleClass('active');
}

// 15.Create order
function createOrder() {
    let endDate = $('#endDate').val();
    let startDate = $('#startDate').val();
    let houseId = $('#houseId').val();
    $.ajax({
        type: 'POST',
        url: '/order/create',
        async: false,
        data: {
            'houseId': houseId,
            'startDate': startDate,
            'endDate': endDate
        },
        success: function (data) {
            if (data.msg == null || data.msg.indexOf('Login') != -1) {
                $('#gotoLogin').click();
                return;
            }
            alert(data.msg);
            if (data.code == 200) {
                window.location.href = '/order/agreement/view?orderId=' + data.result;
            }
        }
    });

}


// 16.Confirm agreement
function confirmAgreement(id) {
    $.ajax({
        type: 'POST',
        url: '/order/agreement/submit',
        async: false,
        data: {
            'orderId': id,
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.href = '/order/pay?orderId=' + data.result;
            }
        }
    });

}


// 16.submit payment
function submitPay(id) {
    $.ajax({
        type: 'POST',
        url: '/order/pay/submit',
        async: false,
        data: {
            'orderId': id,
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.href = '/admin/home';
            }
        }
    });

}


// 17.Cancel order
function cancelOrder(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/order/cancel',
        async: false,
        data: {
            'orderId': id,
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });

}


// 18.Early surrender application
function endOrder(id) {
    if (confirm('Confirm to early surrender of tenancy?')) {
        $.ajax({
            type: 'POST',
            url: '/admin/order/end',
            async: false,
            data: {
                'orderId': id,
            },
            success: function (data) {
                alert(data.msg);
                if (data.code == 200) {
                    window.location.reload();
                }
            }
        });
    }

}


// 19.Disable user
function disableUser(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/user/disable',
        async: false,
        data: {
            'id': id,
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}


// 20.Enable users
function enableUser(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/user/enable',
        async: false,
        data: {
            'id': id,
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}

// 21.Delete News
function deleteNews(id) {
    if (confirm('Confirm to delete news?')) {
        $.ajax({
            type: 'POST',
            url: '/admin/news/delete',
            async: false,
            data: {
                'id': id,
            },
            success: function (data) {
                alert(data.msg);
                if (data.code == 200) {
                    window.location.reload();
                }
            }
        });
    }
}

// 22.Post news
function submitNews() {
    $.ajax({
        type: 'POST',
        url: '/admin/news/publish/submit',
        async: false,
        data: $("#newsForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.href = "/news/detail/" + data.result;
            }
        }
    });
}

// 23.Save house info
function submitHouse() {
    $.ajax({
        type: 'POST',
        url: '/admin/house/publish/submit',
        async: false,
        data: $("#houseForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.href = "/admin/house";
            }
        }
    });
}

// 24.Review approved
function checkPassHouse(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/house/checkPass',
        async: false,
        data: {
            "id": id
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.href = "/admin/house";
            }
        }
    });
}

// 24.Review rejection
function checkRejectHouse(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/house/checkReject',
        async: false,
        data: {
            "id": id
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.href = "/admin/house";
            }
        }
    });
}

// 25.Sent email
function submitContact() {
    $.ajax({
        type: 'POST',
        url: '/house/contact',
        async: false,
        data: $('#contactForm').serialize(),
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        },
        error: function (data) {
            alert('Please fill in the full information');
        },
    });
}


// 26.Application for surrender of rent passed
function endOrderPass(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/order/endPass',
        async: false,
        data: {
            'orderId': id,
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });

}


// 26.Refusal of rent refund application
function endOrderReject(id) {
    $.ajax({
        type: 'POST',
        url: '/admin/order/endReject',
        async: false,
        data: {
            'orderId': id,
        },
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });

}

// 27.Delete user
function deleteUser(id) {
    if (confirm('Confirm to delete user?')) {
        $.ajax({
            type: 'POST',
            url: '/admin/user/delete',
            async: false,
            data: {
                'id': id,
            },
            success: function (data) {
                alert(data.msg);
                if (data.code == 200) {
                    window.location.reload();
                }
            }
        });
    }
}

// 28.Delete post
function deletePost(id) {
    if (confirm('Confirm to delete?')) {
        $.ajax({
            type: 'POST',
            url: '/admin/post/delete',
            async: false,
            data: {
                'id': id,
            },
            success: function (data) {
                alert(data.msg);
                if (data.code == 200) {
                    window.location.reload();
                }
            }
        });
    }
}


// 29.Delete comment
function deleteComment(id) {
    if (confirm('Confirm to delete this comment?')) {
        $.ajax({
            type: 'POST',
            url: '/admin/comment/delete',
            async: false,
            data: {
                'id': id,
            },
            success: function (data) {
                alert(data.msg);
                if (data.code == 200) {
                    window.location.reload();
                }
            }
        });
    }
}

// 30.publish post
function submitPost() {
    $.ajax({
        type: 'POST',
        url: '/admin/post/publish/submit',
        async: false,
        data: $("#postForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.href = "/post/detail/" + data.result;
            }
        }
    });
}


// 31.comment submit
function submitComment() {
    $.ajax({
        type: 'POST',
        url: '/admin/comment/publish/submit',
        async: false,
        data: $("#commentForm").serialize(),  
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        }
    });
}


// 32.Sent potential roommate email
function roommateContact() {
    $.ajax({
        type: 'POST',
        url: '/roommate/contact',
        async: false,
        data: $('#contactForm').serialize(),
        success: function (data) {
            alert(data.msg);
            if (data.code == 200) {
                window.location.reload();
            }
        },
        error: function (data) {
            alert('Please fill in the full information');
        },
    });
}