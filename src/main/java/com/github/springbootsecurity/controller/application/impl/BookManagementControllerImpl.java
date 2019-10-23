package com.github.springbootsecurity.controller.application.impl;

import com.github.springbootsecurity.controller.application.IBookManagementController;
import com.github.springbootsecurity.pojo.doo.UserBookDO;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;
import com.github.springbootsecurity.service.application.IBookManagementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 创建时间为 下午1:02 2019/10/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */



@RestController
@RequestMapping("/admin/center")
@PreAuthorize("hasRole('ROLE_ROOT') or hasRole('ROLE_ADMIN')")
public class BookManagementControllerImpl implements IBookManagementController {

    @Resource
    private IBookManagementService service;

    @GetMapping("/books")
    @Override
    public ReturnDTO<Page<UserBookDO>> findAllBooks(@PageableDefault(size = 4, page = 1, sort = "id", direction = Sort.Direction.ASC)
                                                            Pageable pageable) {
        return ReturnDTO.<Page<UserBookDO>>builder().status(0).data(service.findAllBooks(pageable)).build();
    }

    @PostMapping("/book")
    @Override
    public ReturnDTO<UserBookDO> saveBook(@RequestBody @Valid UserBookDO userBookDO) {
        return ReturnDTO.<UserBookDO>builder().status(0).data(service.saveBook(userBookDO)).build();
    }

    @PutMapping("/book")
    @Override
    public ReturnDTO<UserBookDO> updateBook(@RequestBody @Valid UserBookDO userBookDO) {
        return ReturnDTO.<UserBookDO>builder().status(0).data(service.updateBook(userBookDO)).build();
    }

    @DeleteMapping("/book/{bookId}")
    @Override
    public ReturnDTO<Void> deleteBookById(@PathVariable long bookId) {
        service.deleteBookById(bookId);
        return ReturnDTO.<Void>builder().status(0).build();
    }

}
