var $usernameFld
var $passwordFld
var $firstNameFld
var $lastNameFld
var $roleFld
var $createBtn
var tableRows
var userService = new AdminUserServiceClient()


var users = [
  // {username: "tlee", firstname: "Tim", lastname: "Brins Lee", role: "FACULTY"},
  // {username: "alovelace", firstname: "Ada", lastname: "Lovelace", role: "FACULTY"},
  // {username: "cgarcia", firstname: "Charlie", lastname: "Garcia", role: "STUDENT"},
  // {username: "dcraig", firstname: "Dan", lastname: "Craig", role: "STUDENT"},
  // {username: "sbolivar", firstname: "Simon", lastname: "Bolivar", role: "FACULTY"}
]


function renderUsers(users) {
  tableRows.empty()

  for (var i = 0; i < users.length; i++) {
    var user = users[i];

    tableRows.prepend(
      `
        <tr class="wbdv-template wbdv-user wbdv-hidden">
          <td class="wbdv-username">${user.username}</td>
          <td>&nbsp;</td>
          <td class="wbdv-first-name">${user.firstname}</td>
          <td class="wbdv-last-name">${user.lastname}</td>
          <td class="wbdv-role">${user.role}</td>
          <td class="wbdv-actions">
            <span class="float-right">
              <i id="${i}" class="fa-2x fa fa-times wbdv-remove"></i>
              &nbsp;
              <i class="fa-2x fa fa-pencil wbdv-edit"></i>
            </span>
          </td>
        </tr>
      `
    )
  }

  $(".wbdv-remove").click(deleteUser)
}

function deleteUser(event) {
  var button = $(event.target)
  var id = button.attr("id")
  console.log(id)
  users.splice(id, 1)
  renderUsers(users)
}

function createUser() {
  var newUser = {
    username: $usernameFld.val(),
    firstname: $firstNameFld.val(),
    lastname: $lastNameFld.val(),
    role: $roleFld.val()
  }
  users.push(newUser)
  renderUsers(users)
  $usernameFld.val("")
  $passwordFld.val("")
  $firstNameFld.val("")
  $lastNameFld.val("")
  $roleFld.val("FACULTY")
}

function init() {
  $usernameFld = $("#usernameFld")
  $passwordFld = $("#passwordFld")
  $firstNameFld = $("#firstNameFld")
  $lastNameFld = $("#lastNameFld")
  $roleFld = $("#roleFld")
  $createBtn = $(".wbdv-create")
  tableRows = $(".wbdv-tbody")

  $createBtn.click(createUser)

  userService.findAllUsers()
    .then(function (actualUsersFromServer) {
      users = actualUsersFromServer
      renderUsers(users)
    })
}
// wait until dom has loaded
jQuery(init)





