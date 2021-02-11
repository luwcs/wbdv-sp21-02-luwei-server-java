var $usernameFld
var $passwordFld
var $firstNameFld
var $lastNameFld
var $roleFld
var $createBtn
var $updateBtn
var tableRows
var userService


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
              <i id="${user._id}" class="fa-2x fa fa-pencil wbdv-edit"></i>
            </span>
          </td>
        </tr>
      `
    )
  }

  $(".wbdv-remove").click(deleteUser)

  $(".wbdv-edit").click(editUser)
}

var selectedUser = null
function editUser(event) {
  var editBtn = $(event.target)
  var theId = editBtn.attr("id")
  selectedUser = users.find(user => user._id === theId)
  $usernameFld.val(selectedUser.username)
  $firstNameFld.val(selectedUser.firstname)
  $lastNameFld.val(selectedUser.lastname)
  $roleFld.val(selectedUser.role)
}

function updateUser() {
  selectedUser.username = $usernameFld.val()
  selectedUser.firstname = $firstNameFld.val()
  selectedUser.lastname = $lastNameFld.val()
  selectedUser.role = $roleFld.val()
  userService.updateUser(selectedUser._id, selectedUser)
    .then(function (status) {
      var index = users.findIndex(user => user._id === selectedUser._id)
      users[index] = selectedUser
      renderUsers(users)
    })
}

function deleteUser(event) {
  var deleteBtn = $(event.target)
  var theIndex = deleteBtn.attr("id")
  console.log(theIndex)
  var theId = users[theIndex]._id
  userService.deleteUser(theId)
  .then(function (status) {
    users.splice(theIndex, 1)
    renderUsers(users)
  })
}

function createUser() {
  var newUser = {
    username: $usernameFld.val(),
    password: $passwordFld.val(),
    firstname: $firstNameFld.val(),
    lastname: $lastNameFld.val(),
    role: $roleFld.val()
  }
  userService.createUser(newUser)
    .then(function (actualUser) {
      users.push(actualUser)
      renderUsers(users)
    })
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
  $updateBtn = $(".wbdv-update")
  tableRows = $(".wbdv-tbody")
  userService = new AdminUserServiceClient()

  $createBtn.click(createUser)

  $updateBtn.click(updateUser)

  userService.findAllUsers()
    .then(function (actualUsersFromServer) {
      users = actualUsersFromServer
      renderUsers(users)
    })


}
// wait until dom has loaded
jQuery(init)





